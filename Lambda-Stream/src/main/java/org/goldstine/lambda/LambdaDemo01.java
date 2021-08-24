package org.goldstine.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Lambda表达式
 *  Lambda表达式是jdk1.8开始之后的新技术，是一种代码的新语法
 *      是一种特殊语法
 *          作用：核心目的是为了简化匿名内部类的写法
 *
 *          Lambda表达式的格式：
 *              （匿名内部类的被重写方法的形参列表）->{
 *                  被重写方法的方法体代码
 *              }
 *
 *              Lmabda表达式的使用前提：
 *                  （1）lambda表达式并不能简化所有匿名内部类的写法
 *                  （2）lambda表达式只能简化接口中只有抽象方法的匿名内部类的形式
 *
 * 小结：lambda表达式只能简化接口中只有一个抽象方法的匿名内部类写法
 *      接口中只有一个抽象方法的接口称为函数式接口
 *      lambda只能简化函数式接口的匿名内部类的写法
 *
 * jdk中的函数式接口：一般都会加上注解@FunctionalInterface
 */
public class LambdaDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread t=() -> {
//                System.out.println(Thread.currentThread().getName()+"：执行....");
//            };//lambda表达式并不能简化所有的匿名内部类的写法，只能简化接口中只有一个抽象方法的匿名内部类的形式
        //接口的匿名内部类，并且只有一个抽象方法
        //Runnable接口的匿名内部类的写法可以简化
//
        Runnable r = ()-> {
            System.out.println("lambda表达式简化匿名内部类写法");
        };
        Thread thread = new Thread(r);
        thread.start();


    //进一步简化
    Thread t1=new Thread(()->{
        System.out.println("进一步简化");
    });
    t1.start();

    //最终的简化
        new Thread(()->{
            System.out.println("最终的简化写法");
        }).start();

//
//    //lambda表达式也可以简化Callable接口的写法
//    //带泛型的匿名内部类的写法简化
//
//    Callable<Integer> c=new Callable<Integer>(){
//
//        @Override
//        public Integer call() throws Exception {
//            return null;
//        }
//    };

//        Callable<Integer> c1 = () -> {
//            System.out.println("lambda简化匿名内部类的写法");
//            return 100;
//        };
//        FutureTask<Integer> task = new FutureTask<>(c1);
//        Thread thread = new Thread(task);
//        thread.start();
//        Integer integer = task.get();
//
//        System.out.println(integer);
    }
}
