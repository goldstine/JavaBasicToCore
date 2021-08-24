package org.goldstine.threadcommunication;

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

/**
 * 两个消费者线程+3个生产者线程
 *  锁对象都是通过this   账户acc锁对象
 *
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

    public synchronized void drawMoney(double money){
        try {
            String name = Thread.currentThread().getName();
            //先判断是否可以全款
            if (this.money >= money) {
                this.money -= money;
                System.out.println(name + "来取钱，取钱：" + money + "剩余：" + this.money);
                //取钱之后没钱了，唤醒别人等待自己
                this.notifyAll();
                this.wait();
            }else{
                //如果小明唤醒的是小红，小红取钱，余额不足
                //小红再唤醒，所以进行交替唤醒
                this.notifyAll();
                this.wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //线程通信首先需要保证线程安全，否则毫无意义
    public synchronized void saveMoney(double money) {
        try {
            String name = Thread.currentThread().getName();

            //判断是否账户还有钱没有，开始存钱
            if (this.money > 0) {
                //唤醒来取钱
                this.notifyAll();
                this.wait();
            }else{
                //否者没有钱，三个爸爸开始塞钱
                this.money+=money;
                //塞完钱之后，账户已经有钱，开始唤醒两个儿子来取钱
                System.out.println(name+"来存钱："+money);
                this.notifyAll();
                this.wait();       //再if-else中进行交替唤醒
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
