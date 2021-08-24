package demo03;

import java.util.concurrent.*;

/**
 * 练习异步计算结果
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //1、首先获取一个线程池对象
        ExecutorService es = Executors.newCachedThreadPool();
//        提交任务
        Future<Integer> future = es.submit(new MyTaskCallable(1, 2));
        //获取对应的future接口的对象，然后通过future接口的方法获取对应的返回结果

//        test01(future);
        test02(future);
    }

    private static void test02(Future<Integer> future) throws InterruptedException, ExecutionException, TimeoutException {
        boolean b = future.cancel(true);
        System.out.println(b);//因为线程还在执行过程中，所以取消为true

//        Integer integer = future.get(1, TimeUnit.SECONDS);//等待1秒获取执行结果
//        System.out.println(integer);//由于等待时间过短，会出现异常
    }

    //正常执行流程
    private static void test01(Future<Integer> future) throws InterruptedException, ExecutionException {
        //3、判断是否任务已经完成
        boolean done = future.isDone();
        System.out.println("第一次判断任务是否完成："+done);
        boolean cancelled = future.isCancelled();
        System.out.println("第一次判断任务是否已经取消："+cancelled);
        //不带参数的get()会一直等待任务执行完成
        Integer integer = future.get();//获取线程执行结果时可能线程会中断，所以也会出现中断异常
        System.out.println(integer);

        //正常来说，get()获得结果，说明已经完成并取消
        boolean done2 = future.isDone();
        System.out.println("第二次判断任务是否完成："+done2);
        boolean cancelled2 = future.isCancelled();
        System.out.println("第二次判断任务是否已经取消："+cancelled2);
    }

}

//定义一个Callable接口类型的任务
class MyTaskCallable implements Callable<Integer>{//该接口的泛型对应call()函数的返回值

    //call()同样不带参数，所以通过构造方法传递参数
    private int a,b;

    public MyTaskCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println(name+"准备开始计算....");
        Thread.sleep(2000);
        System.out.println(name+"计算完成....");

        return a+b;
    }
}
