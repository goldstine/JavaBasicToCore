package org.goldstine;

/**
 * 线程的常用api    为了更好地区分不同的线程
 *
 *      public void setName(String name):给当前线程取名字
 *      public void getName();获取当前线程的名字
 *          线程存在默认名称，子线程的默认名称是Thread-索引
 *          主线程的默认名称为main
 *      public static Thread currentThread()
 *          获取当前线程对象，这个代码在哪一个线程中，就得到哪个线程对象
 *
 * 线程休眠api
 *  public static void sleep(long time):让当前线程休眠多少毫秒     静态方法
 *
 *  通过Thread类的有参构造器为当前线程对象取名字
 *      public Thread()
 *      public Thread(String name):创建线程对象并取名字
 *
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        Thread t1 = new MyThread01("1号线程");
//        t1.setName("1号线程");
        t1.start();//启动一个线程一定是start   t.run()通过普通方法调
        System.out.println(t1.getName());

        Thread t2 = new MyThread01("2号线程");
//        t2.setName("2号线程");
        t2.start();
        System.out.println(t2.getName());

//        Thread cu = Thread.currentThread();
//        System.out.println(cu.getName());

        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
//通过继承Thread定义一个线程类
class MyThread01 extends Thread{

    public MyThread01(){}
    public MyThread01(String name) {
        super(name);//线程的名称在父类Thread中        调用父类的有参构造器初始化当前线程的名称
    }

    @Override
    public void run() {//定义任务，线程的执行方法
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }

    }
}
