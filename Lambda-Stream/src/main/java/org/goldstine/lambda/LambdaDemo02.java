package org.goldstine.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;

/**
 * lambda表达式的进一步省略写法
 *      （1）如果lambda表达式的方法体只有一行，可以省略大括号不写，同时要省略分号
 *      （2）如果Lambda表达式的方法体的代码只有一行，可以省略大括号不写
 *              此时，如果这行代码是return语句，必须省略return不写，同时也必须省略;不写
 *       （3）参数类型可以省略不写   所有参数都可以省略，
 *       （4）如果只有一个参数，参数类型可以省略，同时（）也可以省略
 *
 */
public class LambdaDemo02 {
    public static void main(String[] args) {

        new Thread(()->{
            System.out.println("终极省略写法");
        }).start();

        //进一步省略
        new Thread(()->
                System.out.println("进一步省略")   //省略大括号并且省略分号，只有一行，其实也没有必要分号
        ).start();

        new Thread(new FutureTask<Integer>(() -> {
                return 100;

        })).start();


        //如果是这一行为return
        new Thread(new FutureTask<Integer>(()->{
            return 100;
        })).start();

        //进一步省略
        new Thread(new FutureTask<Integer>(()->
            100    //如果选择省略大括号，必须省略分号，并且如果是return 必须省略return
        )).start();

        //参数类型可以进一步省略
        //所有的参数都可以省略


        //集合的遍历

        List<String> names=new ArrayList<String>();
        names.add("胡微光");
        names.add("敢听");
        names.add("洪磊");

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //遍历的简化写法
        names.forEach(s-> System.out.println(s));

    }
}
