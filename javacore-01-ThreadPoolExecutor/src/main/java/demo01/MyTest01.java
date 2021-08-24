package demo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 首先通过Executors的静态方法获取对应的线程池对象【ExecutorService接口的实现类】，然后通过该实现类对象调用ExecutorService接口的方法进行任务的处理  commit  shutdown
 *
 * 通过newCachedThreadPool获取的线程池对象 提交多少个任务就会创建多少个线程
 * 通过newFixedThreadPool获取的线程池对象通过指定固定数量的线程数量
 * 通过newSingleThreadPool获取的线程池对象之会创建一个线程
 * 对应的重载方法都是通过添加一个匿名内部类ThreadFactory的方式自己指定创建线程池中线程的方式
 *
 * 提交的任务可以是Runnable类型任务，也可以是Callable类型任务
 */



/**
 * 联系Executors获取ExecutorService对象，然后调用方法，提交任务
 */
public class MyTest01 {
    public static void main(String[] args) {
        test01();
//        test02();
    }

    private static void test02() {
        //1、使用工厂类获取线程池对象
        ExecutorService es=Executors.newCachedThreadPool(new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称"+n++);
            }
        });
        //2、提交任务，可以使Runnable类型的任务，也可以是Callable类型的任务
        for (int i = 0; i < 10; i++) {
            es.submit(new MTRunnable(i));

        }
    }

    private static void test01() {
        //1、使用工厂类获取线程池对象
        ExecutorService es=Executors.newCachedThreadPool();
        //2、提交任务，可以使Runnable类型的任务，也可以是Callable类型的任务
        for (int i = 0; i < 10; i++) {
            es.submit(new MTRunnable(i));

        }
    }


}

/**
 * 任务类：包含一个任务编号，在任务中，打印出是那一个线程正在执行任务
 */
class MTRunnable implements Runnable{
    private int id;

    public MTRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行力任务...."+id);
    }
}
