package org.goldstine.threadpool;

import java.util.concurrent.*;

/**
 * Callable接口任务类对象做线程池
 *
 */
public class ThreadPoolDemo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService es = Executors.newFixedThreadPool(3);
        //提交对应的任务到线程池
        Callable c1 = new MyCallable(100);

        //Future接口是FutureTask实现类的父接口，所以submit()返回一个FutureTask对象，通过父接口Future接收
        Future<String> submit = es.submit(c1);
        String s = submit.get();
        System.out.println(s);

    }
}

//创建一个Callable任务类对象
class MyCallable implements Callable<String>{

    private int n;
    public MyCallable(int n){
        this.n=n;
    }
    @Override
    public String call() throws Exception {
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        return Thread.currentThread().getName()+"=>"+sum;
    }
}
