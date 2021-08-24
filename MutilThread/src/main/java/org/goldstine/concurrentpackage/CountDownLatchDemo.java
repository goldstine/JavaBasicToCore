package org.goldstine.concurrentpackage;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：类似于join(),但是比join更灵活
 *      CountDownLatch允许一个或多个线程等待其他线程完成操作，在执行自己
 *      例如：线程1要执行打印：A和C  线程2要执行打印：B ,但是线程1在打印1之后
 *          要线程2打印B之后，才能打印C,所以，线程1在打印A后
 *          必须等待线程2打印完B之后才能继续执行
 *
 *          构造器：
 *              public CountDownLatch(int count);//初始化唤醒需要的down几步
 *           方法：
 *           public void await() throws InterruptedException//让当前线程等待，必须down
 *
 *           public void countDown() //计数器进行减1（down 1）
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //创建一个CountDownLatch控制线程A,B的执行
        CountDownLatch latch = new CountDownLatch(1);

//        new ThreadA(latch).start();
//        new ThreadB(latch).start();  //A  B  C

        //如果先执行线程ThreadB
        new ThreadB(latch).start();    //B  A  C
        new ThreadA(latch).start();

    }
}

class ThreadA extends Thread{
    private CountDownLatch latch;
    public ThreadA(CountDownLatch latch){
        this.latch=latch;
    }
    @Override
    public void run() {
        System.out.println("A");
        //等待自己
        try {
            //等待自己根据监督者中的数量1决定让当前线程让出cpu等待自己
            latch.await();//自己进入等待状态，让出自己的cpu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("C");
    }
}
class ThreadB extends Thread{

    //创建监督者对象进行监督线程执行
    private CountDownLatch latch;
    public ThreadB(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        System.out.println("B");
        //执行自己的
        latch.countDown();//将计算器减1，减1之后监督对象的计数器减到0之后，重新进行唤醒
        //如果构造器的初始计数器值为2，需要唤醒两次
//        latch.countDown();
    }
}