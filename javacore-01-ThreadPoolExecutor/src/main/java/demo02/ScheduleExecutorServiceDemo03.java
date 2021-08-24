package demo02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 测试newScheduleExecutorService线程池对应的   scheduleWithFixedDelay()
 */
public class ScheduleExecutorServiceDemo03 {

    public static void main(String[] args) {
//        test01();
        test02();
    }

    private static void test02() {
        //1、获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义线程名:"+n++);
            }
        });
        //2、创建多个任务对象，提交任务，每个任务延迟2秒执行
        //通过schedule()提交一个任务到线程池
//        es.schedule(new MyTaskRunnable3(1),2, TimeUnit.SECONDS);

//        es.scheduleAtFixedRate(new MyTaskRunnable3(1),1,2, TimeUnit.SECONDS);//任务的执行时间包含在间隔时间中

        es.scheduleWithFixedDelay(new MyTaskRunnable3(1),1,2,TimeUnit.SECONDS);

        System.out.println("over");//main线程不会延迟，直接先输出
    }

    private static void test01() {
        //1、获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
        //2、创建多个任务对象，提交任务，每个任务延迟2秒执行
        //通过schedule()提交一个任务到线程池
//        es.schedule(new MyTaskRunnable2(1),2, TimeUnit.SECONDS);

        //提交多个任务
        for (int i = 0; i < 10; i++) {
            es.schedule(new MyTaskRunnable3(i),2, TimeUnit.SECONDS);
        }

        System.out.println("over");//main线程不会延迟，直接先输出
    }

}

class MyTaskRunnable3 implements Runnable{

    private int id;

    public MyTaskRunnable3(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"执行了任务"+id);
    }
}
