package org.goldstine.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池：如果并发的线程数量很多，并且每一个线程都是执行一个短时间的任务就结束了，这样频繁创建线程就会大大降低系统的效率，因为频繁创建线程和销毁线程需要时间
 *      线程也属于宝贵的系统资源
 *
 *      线程池可以使线程复用，就是执行完一个任务，并不被销毁，而是可以继续执行其他任务
 *      线程池的好处：
 *          （1）降低资源消耗
 *          （2）提高响应速度
 *          （3）提高线程的可管理性（线程池可以约束系统最多只能有多少个线程，不会因为线程过多而死机）
 */
public class ThreadPoolDemo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池，指定现成的固定数量
        ExecutorService es = Executors.newFixedThreadPool(3);
        //往线程池添加任务
        Runnable target = new MyRunnable();
        es.submit(target);//第一次提交任务，此时创建线程执行任务
        es.submit(target);//第二次提交任务，此时创建新线程执行任务
        es.submit(target);//第三次提交任务，此时创建新的线程执行任务
        es.submit(target);//第四次提交任务，复用线程

        es.shutdown();//等待任务执行完毕以后才会关闭线程池
//        es.shutdownNow();//立即关闭线程池，无论任务是否执行完毕，只要主线程main执行到这，就立即关闭任务线程
    }
}

//创建一个任务类对象
class MyRunnable extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"======>"+i);
        }
    }
}
