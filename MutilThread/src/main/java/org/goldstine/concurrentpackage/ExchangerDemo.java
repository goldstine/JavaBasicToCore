package org.goldstine.concurrentpackage;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Exchanger：交换者：是一个用于线程之间协作的工具类，Exchanger用于进行线程之间数据交换
 *  这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()，它会一直等待第二个也执行exchange()
 *  当两个线程都到达同步电视，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方
 *
 *  Exchanger构造方法：
 *      public Exchanger()
 *   Exchanger方法：
 *   public V exchange(V x)
 *   （1）需要两个线程
 *   （2）需要一个交换对象负责交换两个线程执行的结果
 *
 *   小结：Exchanger可以实现两个线程之间交换数据
 *
 * 使用场景：
 *  可以做数据校对工作
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        Exchanger<String> e=new Exchanger<String>();
        new Boy(e).start();
        new Girl(e).start();
    }
}

class Boy extends Thread{
    private Exchanger<String> exchanger;
    public Boy(Exchanger<String> exchanger){
        this.exchanger=exchanger;
    }
    @Override
    public void run() {
        System.out.println("男孩开始做好自己的定情信物：同心锁");
        try {
            //交换结果：男孩送出自己的定情信物，交换女孩的礼物
//            String rs = exchanger.exchange("同心锁");
            //可以设置等待时间
            //等待了5s对象还不与他交换，就抛出异常！！TimeoutException
            String rs = exchanger.exchange("同心锁", 5, TimeUnit.SECONDS);

            System.out.println("男孩收到的礼物："+rs);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }

    }
}

class Girl extends Thread{
    private Exchanger<String> exchanger;
    public Girl(Exchanger exchanger){
        this.exchanger=exchanger;
    }
    @Override
    public void run() {
        System.out.println("女孩开始做好自己的定情信物：钥匙");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String rs = null;
        try {
            rs = exchanger.exchange("钥匙");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("女孩收到的礼物："+rs);
    }
}
