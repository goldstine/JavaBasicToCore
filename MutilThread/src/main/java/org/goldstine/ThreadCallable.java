package org.goldstine;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三：实现Callable接口
 *  （1）定义一个线程任务类实现Callable接口，申明线程执行的结果类型
 *  （2）重写线程任务类的call方法这个方法可以直接返回执行的结果
 *  (3)创建一个callable线程任务对象
 *  (4)把Callable的线程任务对象包装成一个线程任务对象
 *  （5）把线程任务对象包装成线程对象
 *  （6）调用线程的start()方法启动线程
 *
 *      优点：具有Runnable接口实现的所有优点
 *      （1）线程任务类只是实现类Callable接口，可以继续继承其他类，同时可以继续实现其他接口
 *      (2)一个线程任务对象可以同时被共享成多个线程对象，适合做多线程的资源共享操作
 *      (3)很适合做线程池的执行任务
 *      （4）可以直接获取线程执行结果
 *
 */
public class ThreadCallable {
    public static void main(String[] args) {
        Callable<String> c1 = new MyCallable();
//        c1.start();//c1对象是任务类对象，不是线程对象，所以没有start()
        //将线程任务类对象包装成线程对象
//        Thread t1 = new Thread(c1);//Thread的构造方法没有对应的构造器进行Callable任务对象包装

        //需要把Callable任务对象包装成一个未来任务对象
        //public FutureTask(Callable<V> callable)
        /**
         * FutureTask实际上就是一个Runnable接口
         *  FutureTask类实现类RunnableFuture接口,而RunnableFuture接口继承Runnable接口，实现接口继承，抽象方法的汇聚
         *  //Runnable任务对象可以包装成线程对象Thread(Runnable任务类对象）
         *
         *  为什么要这样设计：原因
         *      未来任务对象可以在线程执行完毕之后去得到线程执行的结果
         */
//        Runnable stringFutureTask = new FutureTask<>(c1);
        FutureTask<String> task = new FutureTask<>(c1);
        //通过FutureTask类的构造方法可以包装Runnable和Callable任务类对象

        //包装
        Thread t1 = new Thread(task);//task是Runnable的子类，子类赋值给父类Runnable任务类对象，参数接收
        t1.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"=>"+i);
        }

        //到最后取结果，
        //问题可能主线程执行完到这里，子线程还没有执行，没有结果；如果线程没有结果，【主线程】让出CPU等线程执行完再来去结果
        try {
            String rs=task.get();//获取call方法返回的结果（正常/异常结果）
            System.out.println(rs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {//抛出异常，说明该方法既可以返回正常结果，也可以返回异常结果
        //计算1-10的和返回
        int sum=0;
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()+"=>"+i);
            sum+=i;
        }
        return Thread.currentThread().getName()+"执行结果是:"+sum;
    }
}