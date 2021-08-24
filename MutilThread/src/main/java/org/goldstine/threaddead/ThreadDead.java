package org.goldstine.threaddead;

/**
 * 死锁
 *      死锁：多个线程同时被阻塞，他们中的一个或者全部都在等待某一个资源被释放
 *      由于线程被无限期地阻塞，因此线程不可能正常终止
 *
 *      客户（占用资金，等待经销商的货物资源）     经销商（占用货物资源，等待客户资金）
 *
 *      java产生死锁的四个必要条件
 *          （1）互斥使用，即当资源被一个线程使用时，别的线程不能使用
 *          （2）不可抢占：资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放
 *          （3）请求和保持：即当资源请求者在请求其他资源的同时保持对原有资源的占有
 *          （4）循环等待，即存在一个等待循环队列，p1要p2的资源，p2要p1的资源，形成一个循环等待
 *             当上述四个条件都成立的时候，形成死锁，反过来，思索情况下如果打破上述任何一个条件，便可让死锁消失
 *
 *
 *             实现一个必然死锁的案例
 *            小结：
 *                  死锁的代码形式上通常需要进行锁的嵌套访问
 */
public class ThreadDead {
    //定义一个资源对象
    public static Object resources01=new Object();
    public static Object resources02=new Object();

    public static void main(String[] args) {
        //定义2个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resources01){
                    System.out.println("线程1占用资源1请求资源2");
                    try {
                        Thread.sleep(1000);//计时等待1秒一定会线程2将资源2锁住，所以一定会死锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resources02){
                        System.out.println("线程1成功占用资源2");
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resources02){
                    System.out.println("线程2占用资源2请求资源1");
                    try {
                        Thread.sleep(1000);//计时等待1秒一定会线程2将资源2锁住，所以一定会死锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resources01){
                        System.out.println("线程2成功占用资源1");
                    }
                }
            }
        }).start();
    }

}
