package org.goldstine;

/**
 * 多线程概述（并发编程 JUC）
 *  什么是进程，程序时静止的，运行中的程序就是进程
 *  进程的三个特性：
 *      （1）动态性：进程是运行中的程序，要动态地占用内存，cpu和网络等资源
 *      （2）独立性，进程与进程之间是相互独立的，彼此有自己的独立内存区域
 *      （3）并发性，加入cpu是单核，同一个时刻其实内存中只有一个进程在被执行
 *              cpu会分时轮询切换依次为每个进程服务，因为切换的速度非常快，给我们的感觉这些进程在同时执行，这就是并发性
 *
 *         并行，同一个时刻同时有多个在执行
 *       线程：
 *       线程是属于进程的，一个进程可以包含多个线程，就是多线程
 *       线程创建开销相对进程来说比较小
 *       线程也支持并发性
 *
 *
 *
 *          通过Thread创建线程的缺点
 *          优点是编码简单
 *          缺点：线程已经继承了Thread类无法继承其它类了，功能不能通过继承拓展（单继承的缺点）
 *
 *          线程类继承Thread的类
 *          启动线程必须调用start
 *
 *          start()底层其实是给cpu注册当前线程，并且触发run()方法执行
 *
 *          建议线程先创建子线程，主线程的任务放在之后。如果主线程放在子线程启动之前，都会先执行主线程完毕，然后再启动子线程执行
 *
 *
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();//启动一个线程一定是start   t.run()通过普通方法调
        for (int i = 0; i < 5; i++) {
            System.out.println("main线程输出："+i);
        }
    }
}
//通过继承Thread定义一个线程类
class MyThread extends Thread{
    @Override
    public void run() {//定义任务，线程的执行方法
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程输出："+i);
        }

    }
}