package demo01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MyTest02 {

    public static void main(String[] args) {
//        test01();
        test02();
    }

    private static void test02() {
        //1、使用工厂类获取线程池对象
        ExecutorService es= Executors.newFixedThreadPool(3,new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称"+n++);
            }
        });
        //2、提交任务，可以使Runnable类型的任务，也可以是Callable类型的任务
        for (int i = 0; i < 10; i++) {
            es.submit(new MTRunnable2(i));

        }
    }

    private static void test01() {
        //1、使用工厂类获取线程池对象
        ExecutorService es=Executors.newFixedThreadPool(3);
        //2、提交任务，可以使Runnable类型的任务，也可以是Callable类型的任务
        for (int i = 0; i < 10; i++) {
            es.submit(new MTRunnable2(i));

        }
    }

}
/**
 * 任务类：包含一个任务编号，在任务中，打印出是那一个线程正在执行任务
 */
class MTRunnable2 implements Runnable{
    private int id;

    public MTRunnable2(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行力任务...."+id);
    }
}

