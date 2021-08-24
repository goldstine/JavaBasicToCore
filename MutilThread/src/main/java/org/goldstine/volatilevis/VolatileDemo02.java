package org.goldstine.volatilevis;

/**
 * 并发编程下变量不可见性解决方案
 *      解决方案有两种常见方式：
 *  （1）加锁
 *          while(true){
 *             synchronized (VisiblityDemo01.class) {
 *                 if (t1.isFlag()) {
 *                     System.out.println("主线程进入执行.....");
 *                 }
 *             }
 *         }
 *         加锁的执行流程：
 *         （1）线程获得锁
 *         （2）清空工作内存
 *         （3）从主内存中拷贝共享变量最新的值到工作内存成为副本
 *         （4）执行代码
 *         （5）将修改的副本的值刷新回主内存
 *         （6）线程释放锁
 * （2）对共享变量进行volatile关键字修饰
 *      volatile修饰的变量在多线程并发修改的情况下，实现线程间变量的可见性
 *      一旦一个线程修改了volatile修饰的变量，另一个线程可以立即取到最新值
 *
 *
 *      volatile与synchronized的比较说明：
 *          （1）volatile修饰实例变量和类变量，而synchronized可以修饰方法，以及代码块
 *          （2）volatile保证数据的可见性，但是不保证原子性（多线程进行写操作，不保证线程安全）而synchronized是一种排他（互斥）机制
 *
 */
public class VolatileDemo02 extends Thread{
    private volatile boolean flag=false;

    //重写线程run()


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程中修改变量
        flag=true;
        System.out.println("flag="+flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

//编写主类
class VisiblityDemo01{
    public static void main(String[] args) {
        //创建子线程，修改flag
        VolatileDemo02 t1 = new VolatileDemo02();
        t1.start();

        while(true){
            if (t1.isFlag()) {
                System.out.println("主线程进入执行.....");
            }

        }

        //直接通过加锁的方式会降低性能
//        while(true){
//            synchronized (VisiblityDemo01.class) {//方法为静态方法，所以锁对象为类名.class
//                if (t1.isFlag()) {
//                    System.out.println("主线程进入执行.....");
//                }
//            }
//        }
    }
}
