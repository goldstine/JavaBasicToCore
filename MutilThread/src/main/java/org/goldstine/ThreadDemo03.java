package org.goldstine;

/**
 * 方式二实现Runnale接口的匿名内部类的写法
 *
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        Runnable target = new Runnable() {//通过匿名内部类定义一个任务类对象

            @Override
            public void run() {
                for (int i = 0; i < 105; i++) {
                    System.out.println(Thread.currentThread().getName()+"======>"+i);
                }
            }
        };

        Thread thread = new Thread(target, "1号线程");
        thread.start();


        //简化写法
        new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 105; i++) {
                    System.out.println(Thread.currentThread().getName()+"====>"+i);
                }
            }
        },"2号线程").start();



        for (int i = 0; i < 105; i++) {
            System.out.println(Thread.currentThread().getName()+"======"+i);
        }
    }
}
