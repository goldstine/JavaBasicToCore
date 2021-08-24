package org.goldstine.threadcommunication;

/**
 * 线程通信
 *      线程通信：多个线程因为在同一个进程中，所以互相通信比较容易
 *     线程通信的经典模型：生产者与消费者问题
 *          生产者负责生成商品，消费者负责消费商品
 *          生产不能过剩，消费不能没有
 *
 *     线程通信一定是多个线程在操作同一资源才需要进行通信
 *     线程通信必须先保证线程安全，否则毫无意义，代码也会报错
 *
 *     线程通信的Object提供核心方法：
 *          public void wait();让当前线程进入到等待状态   此方法必须锁对象调用
 *          public void notify():唤醒当前锁对象上等待状态的某个线程，此方法必须锁对象调用      唤醒所有线程中的某一个线程
 *          public void notifyAll();唤醒当前锁对象上等待状态的全部线程，此方法必须锁对象调用     唤醒所有线程
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        //创建一个共享账户
        Account acc = new Account("ICBC-110",0);
        //创建2个线程对象代表小明和小红,直接启动线程开始取钱
        new DrawThread(acc,"小明").start();
        new DrawThread(acc,"小红").start();

        //创建三个存钱的线程
        new SaveThread(acc,"亲爹").start();
        new SaveThread(acc,"干爹").start();
        new SaveThread(acc,"岳父").start();

    }
}
