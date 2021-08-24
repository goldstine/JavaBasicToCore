package demo04;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟秒杀商品的案例
 */

public class MyTest {

    public static void main(String[] args) {
        //通过构造函数创建线程池的方式7
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(15));
        //创建对应的核心线程数3   最大线程数5   最大空闲时间1min    任务队列的大小为15个队列
        //循环创建20个任务对象
        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask("客户" + i);
            pool.submit(myTask);
        }
        //关闭线程池
        pool.shutdown();

    }

}
