package org.goldstine;

/**
 * 创建线程Runnable接口方法
 *      (1)创建一个线程任务实现Runnable接口
 *      （2）重写run()
 *      （3）创建一个线程任务对象
 *      (4)把线程任务对象包装成线程对象
 *          Thread的构造器：
 *              public Thread();
 *              public Thread(String name);
 *              public Thread(Runnable target);
 *              public Thread(Runnable target,String name);
 *      （5）start()
 *
 * 实现Runnable接口创建线程的优缺点：
 *      缺点：代码复杂一点
 *      优点：
 *          线程任务类只是实现类Runnable接口，可以继续继承其他类，而且可以继续实现其他接口
 *          + 同一个线程任务对象可以包装成多个线程对象
 *              适合多个相同的程序代码的线程共享同一个资源
 *           实现类任务和代码的解耦操作，代码和线程独立
 *           线程池可以放入实现Runnable或Callable线程任务对象
 *                  注意：其实Thread类本身也是实现了Runnable接口的
 */
public class ThreadDemo02 {

    public static void main(String[] args) {
        //创建一个线程任务对象(注意：线程任务对象不是线程对象，只是执行线程的任务的)
        Runnable target = new MyRunnable();
//        target.start();//因为target不是线程对象，所以没有start()方法
        //将Runnable任务类对象通过Thread构造器包装成Thread对象
        Thread t = new Thread(target,"1号线程");
        //调用线程对象的start()
        t.start();

        //同一个线程任务对象可以包装成多个线程对象
        Thread t2 = new Thread(target, "2号线程");
        t2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"=====>"+i);
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"=====>"+i);
        }
    }
}