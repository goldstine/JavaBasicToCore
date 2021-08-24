package demo01;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 测试关闭线程池的方法  shutdown    shutdownnow
 */

/**
 * 三种创建线程池的方式比较：newCachedThreadPool   newFixedThreadPool   newSingleThreadPool
 * newCachedThreadPool :每一个任务都创建一个线程，以任务性能为导向
 * newFixedThreadPool :如果服务器性能不行，可以创建固定数量线程的线程池
 * newSingleThreadPool：如果只追求安全，可以考虑使用一个线程的线程池
 */


public class MyTest04 {

    public static void main(String[] args) {
//        test01();
        test02();
    }

    private static void test02() {
        //1、使用工厂类获取线程池对象
        ExecutorService es= Executors.newSingleThreadExecutor(new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义的线程名称"+n++);
            }
        });
        //2、提交任务，可以使Runnable类型的任务，也可以是Callable类型的任务
        for (int i = 0; i < 10; i++) {
            es.submit(new MTRunnable4(i));

        }
        //通过shutdownnow()立刻关闭线程池，如果线程池中还有缓存的任务，没有执行，则取消执行，并返回这些任务的集合
        List<Runnable> runnables = es.shutdownNow();
        System.out.println("开始打印被缓存的任务：");
        System.out.println(runnables);
    }

    private static void test01() {
        //1、使用工厂类获取线程池对象
        ExecutorService es=Executors.newSingleThreadExecutor();
        //2、提交任务，可以使Runnable类型的任务，也可以是Callable类型的任务
        for (int i = 0; i < 10; i++) {
            es.submit(new MTRunnable4(i));

        }


        //3、关闭线程池，仅仅是不再接受新的任务，以前的任务还会继续执行
        es.shutdown();
        //4、此时如果再提交一个任务，不会再执行
//        es.submit(new MTRunnable(888));      一旦关闭之后，不能再提交任务，会出现异常RejectedExecutionException
    }


}
/**
 * 任务类：包含一个任务编号，在任务中，打印出是那一个线程正在执行任务
 */
class MTRunnable4 implements Runnable{
    private int id;

    public MTRunnable4(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"执行力任务...."+id);
    }

    @Override
    public String toString() {
        return "MTRunnable4{" +
                "id=" + id +
                '}';
    }
}
