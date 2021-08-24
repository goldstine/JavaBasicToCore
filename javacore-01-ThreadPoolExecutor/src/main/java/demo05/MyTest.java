package demo05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 线程池使用步骤（5步）：
 *      （1）利用Executors工厂类的静态方法，创建线程池对象
 *      （2）编写Runnable或Callable实现类的实例对象
 *      （3）利用ExecutorService的submit()方法 或  ScheduleExecutorService的schedule()提交并执行线程任务
 *      (4)如果有执行结果，处理异步执行结果Future
 *      （5）调用shutdown()关闭线程池
 */




/**
 * 创建线程池进行2个取钱用户的模拟
 */
public class MyTest {
    public static void main(String[] args) {
        //创建线程池的方式：
        /***
         * (1)通过构造函数  ThreadPoolExecutor()
         * (2)通过Executors的静态方法  创建接口ExecutorService对象  创建ScheduledExecutorService接口的对象
         */
        //1.创建固定数量2个的线程池
        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"ATM"+n++);
            }
        });

        //模拟两个用户在不同的ATM机上进行取款，创建两个任务并提交
        for (int i = 0; i < 2; i++) {
            MyTask myTask = new MyTask("名称" + (i + 1), 800);
            es.submit(myTask);
        }
        //最后不要忘记关闭线程池
        es.shutdown();
    }
}
