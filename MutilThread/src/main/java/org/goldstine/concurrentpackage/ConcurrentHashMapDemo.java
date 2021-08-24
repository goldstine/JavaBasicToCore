package org.goldstine.concurrentpackage;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发包的介绍（面试中的重点中的重点）
 * 并发包的来历：
 *       在实际开发中如果不需要考虑线程安全问题，大家不需要做线程安全，因为如果做了反而性能会降低
 *       但是实际开发中许多业务时需要考虑线程安全问题的，此时就必须考虑了，否则业务出现问题
 *       java为很多业务场景提供了性能优异，且线程安全的并发包
 *
 *       Map集合中的经典集合，HashMap是线程不安全的，性能好
 *              为了保证线程安全，可以使用HashTable，线程中加入了计时
 *              --Hashtable是线程安全的Map集合，但是性能较差（已经被淘汰了，虽然安全，但是性能较差）
 *         为了保证线程安全，再看concurrentMap（不止线程安全，而且效率高，性能好）
 *         concurrentHashMap保证了线程安全，综合性能较好
 *
 * Hashtable与ConcurrentHashMap之间进行比较  分别是如何保证线程安全的
 *  Hashtable所整个集合，线程安全，性能较差
 *  ConcurrentHashMap线程安全，性能得到极大提高，分段式锁，之所自己操作的元素位置，综合性能最好，建议使用
 *
 */
public class ConcurrentHashMapDemo {
    //演示HashMap在高并发下的线程不安全性
//    public static Map<String,String> maps=new HashMap<>();//线程不安全
    public static Map<String,String> maps=new Hashtable<>();//线程安全，但是性能较差
//    public static Map<String,String> maps=new ConcurrentHashMap<>();

    /**
     * ConcurrentHashMap
     * 线程1耗时：0.227
     * 线程2耗时：0.689
     * Hashtable:
     * 线程1耗时：0.285
     * 线程2耗时：0.285
     */
    public static void main(String[] args) {
        Runnable target = new MyRunnable();
       Thread t1= new Thread(target,"线程1");
        Thread t2=new Thread(target,"线程2");

        t1.start();
        t2.start();

        try {
            t1.join();//让t1跑完
            t2.join();//让t2跑完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //等两个线程执行完毕之后去获取集合最终的元素个数
        System.out.println("元素个数："+maps.size());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        for (int i = 1; i <= 500000; i++) {
            ConcurrentHashMapDemo.maps.put(Thread.currentThread().getName()+i,i+" ");
        }
        long endTime=System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"耗时："+(endTime-startTime)/1000.0);
    }
}
