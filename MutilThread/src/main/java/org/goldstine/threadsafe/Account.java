package org.goldstine.threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步——同步代码块
 * 线程同步的作用：就是为了解决线程安全问题的方案
 * 线程同步解决线程安全问题的核心思想：
 *      让多个线程实现先后依次访问共享资源
 *
 * 线程同步的做法： 是把共享资源进行上锁，每次只能一个线程进入访问完毕之后，其他线程才能进来
 *
 * 线程同步的三种方式
 *              （1）同步代码块
 *              （2）同步方法
 *              （3）lock显式锁
 *
 *         同步代码块：
 *              作用：把出现线程安全问题的核心代码给上锁，每次只能一个线程进入
 *                      执行完毕之后自动解锁，其他线程才可以进来执行
 *                格式：
 *                synchronized(锁对象){
 *                    //访问共享资源的核心代码
 *                }
 *                锁对象：理论上可以是任意的“唯一”对象即可
 *                原则上，锁对象建议使用共享资源
 *          在实例方法中减一用this作为锁对象，此时this正好是共享资源
 *          在静态方法中建议用类名.class字节码作为锁对象
 *
 *          同步代码块的锁的范围越精细越好
 *
 *          同步方法：
 *              作用：把出现线程安全问题的核心方法给锁起来
 *                      每次只能一个线程进入访问 ，其他线程必须在方法外面进行等待
 *               用法：直接给方法加上修饰符synchronized
 *               原理：和同步方法快的原理相同
 *                  同步方法底层其实也是有锁对象的
 *                      如果方法是实例方法：同步方法默认用this作为锁对象
 *                      如果方法是静态方法：同步方法默认用类名.class作为锁对象
 *
 *
 *           显示锁：
 *           java.util.concurrent.locks.Lock机制提供了比synchronized代码块和同步方法更强大的功能
 *           Lock锁也称为同步锁，加锁与释放锁方法化了
 *              public void lock();加同步锁
 *              public void unlock();释放同步锁
 *
 *
 *
 *          总结：
 *                  线程安全，性能差    锁阻塞
 *                  线程不安全性能好，假如开发中不会出现多线程安全问题，建议使用线程不安全设计
 *                      StringBuilder线程不安全的
 *                      StringBuffer线程安全的（淘汰了）
 */
public class Account {
    private String cardID;
    private double money;

    //创建一把锁对象，需要唯一:因为账户对象对于小明和小红是唯一的，所以这里的锁对象对于小明和小红来说也是唯一的
    //为了保证唯一 加上final关键字
    //Lock接口，对应的实现类ReetrantLock
    private final Lock lock=new ReentrantLock();

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //账户取钱    取钱的逻辑属于账户，所以在账户中进行取钱操作
//    public void drawMoney(double money) {
//        //先知道是谁来取钱
//        String name=Thread.currentThread().getName();
//        //判断余额是否足够
//        //共享资源:当前账号====this
////        System.out.println(this);this表示调用该方法的对象acc  两个用户的账户对象为同一个
//        synchronized (this){
//            if(this.money>=money){
//                System.out.println(name+"来取钱，余额足够，吐出"+money);
//                //更新余额
//                this.money-=money;
//                System.out.println(name+"来取钱之后，余额剩余"+this.money);
//            }else{
//                System.out.println(name+"来取钱，余额不足！");
//            }
//        }
//    }

    //同步方法
    public /*synchronized*/ void drawMoney(double money) {
        //先知道是谁来取钱
        String name=Thread.currentThread().getName();
        //判断余额是否足够
        //共享资源:当前账号====this
//        System.out.println(this);this表示调用该方法的对象acc  两个用户的账户对象为同一个

        lock.lock();
        try {
            if (this.money >= money) {
                System.out.println(name + "来取钱，余额足够，吐出" + money);
                //更新余额
                this.money -= money;
                System.out.println(name + "来取钱之后，余额剩余" + this.money);
            } else {
                System.out.println(name + "来取钱，余额不足！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();//不管是正常执行还是异常执行，都会执行锁的释放
        }
//        lock.unlock();//如果直接这样写，会出现问题，如果某一个线程执行抛出异常，锁一直不能进行释放，其他线程也不能执行，所以一概放在finaly释放资源
    }
}
