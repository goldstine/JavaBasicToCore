package org.goldstine.lambda.stream;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Stream流的常用API
 *      forEach():逐一处理（遍历）
 *      count()统计个数
 *              long count()
 *      filter():过滤元素
 *      limit()取前几个元素
 *      skip()跳过前几个
 *      map()加工方法
 *      concat()合并流
 *          合并方法是一个静态方法： public static <T> Stream<T> concat(Strean<? extends T>a ,Strean<? extends T>b)
 */
public class StreamApi {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

//        list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.length()==3;
//            }
//        });
        //简化之后
        list.stream().filter(s->s.length()==3).filter(s->s.startsWith("张")).forEach(System.out::println);
        //count统计数量
        long count = list.stream().filter(s -> s.length() == 3).filter(s -> s.startsWith("张")).count();
        System.out.println(count);

        //limit(int n);取前n个元素
        list.stream().filter(s->s.length()==3).limit(2).forEach(System.out::println);

        System.out.println("++++++++++++++++++++");
        //skip(int n)跳过前面n个元素
        list.stream().filter(s->s.length()==3).skip(1).forEach(System.out::println);


        //对流进行加工map
        //把名字都加上goldstine
        list.stream().map(s->"Goldstine:"+s).forEach(System.out::println);
        System.out.println("map将字符串加工成对象再放到stream()上");
        //需求：把名称都加工成学生对象放上去，放到stream()流上去，所以首先创建对应的Student对象类
        list.stream().map(s->new Student(s)).forEach(System.out::println);
        //上面的s->new Student(s)参数作为构造方法的参数，所以可以进一步通过构造方法引用进一步简化
        System.out.println("进一步简化构造函数引用");
        list.stream().map(Student::new).forEach(System.out::println);


        //对多个流进行合并
        //首先创建一个数组流，通过Stream.of(可变参数【】可以传入0个1个多个，数组元素作为参数)
        Stream<Integer> s1 = Stream.of(10, 20, 30, 40);
        //创建一个集合流
        Stream<String> stream = list.stream();
        //Integer类型的流与String类型的流进行合并，会得到一个Object类型的流
        Stream<Object> concat = Stream.concat(s1, stream);
        //通过forEach()将流Stream进行遍历输出
        concat.forEach(System.out::print);

    }
}
