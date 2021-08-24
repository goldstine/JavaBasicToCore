package demo02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试子接口ScheduleExecutorService接口的线程池对象
 * 测试延迟执行任务和重复执行任务
 */
public class ScheduleExecutorServiceDemo01 {

    public static void main(String[] args) {
        //1、获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
        //2、创建多个任务对象，提交任务，每个任务延迟2秒执行
        //通过schedule()提交一个任务到线程池
//        es.schedule(new MyTaskRunnable(1),2, TimeUnit.SECONDS);

        //提交多个任务
        for (int i = 0; i < 10; i++) {
            es.schedule(new MyTaskRunnable(i),2,TimeUnit.SECONDS);
        }

        System.out.println("over");//main线程不会延迟，直接先输出
    }

}

class MyTaskRunnable implements Runnable{

    private int id;

    public MyTaskRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行了任务"+id);
    }
}
