package org.goldstine.concurrentpackage;

import java.util.concurrent.Semaphore;

/**
 * semaphore（发信号）的主要作用是控制线程的并发数量     控制流量的问题
 *
 * semaphore可以设置同时允许几个线程执行
 * 构造方法：
 *      public Semaphore(int permits)://permits表示许可的线程数量
 *      public Semaphore,boolean fair)//fair表示公平性，如果设为true，下一次执行的线程会是等待最久的线程
 *
 *      方法：
 *      public void acquire() throws InterruptedException  表示许可
 *      public void release()       release()表示释放许可
 *
 * Semaphore可以控制线程并发占锁的数量
 *
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 1; i <= 5; i++) {
            Thread a = new MyThread(service);
            a.start();
        }
    }
}

class MyThread extends Thread{
    //接收业务对象，所有的线程都是同一个业务对象
    private Service service;
    public MyThread(Service service){
        this.service=service;
    }
    @Override
    public void run() {
        service.login();//5个线程同时执行业务对象中的login()
    }
}

//定义一个登陆的业务对象类
class Service {
    private Semaphore semaphore=new Semaphore(2);
    //表示每次允许两个进入访问login方法，不能够保证安全问题，所以semaphore用于保证流量问题

    //表示最多允许1个线程执行acquire()和release()之间的内容

    public void login(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "进入 时间" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "登陆成功...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "离开 时间" + System.currentTimeMillis());
            semaphore.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
