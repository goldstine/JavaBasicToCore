package org.goldstine.lambda.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 终结与非终结方法
 * 终结方法：一旦Stream调用了终结方法，流的操作就全部终结了，不能继续使用了
 *              只能创建新的Stream操作
 *              终结流forEach()  count()
 *
 *          非终结方法：每次调用完之后返回一个新的流对象
 *                可以继续使用，支持链式编程
 *
 *
 *   收集Stream流：把Stream流的数据转回成集合
 *   引入：
 *      Stream的作用是：把集合转换成一根传送带，借用Stream流的强大功能进行操作
 *      但是实际开发中高数据最终的形式还是集合。最终Stream流操作完毕以后还是要转换成集合
 *      这就是收集Stream流
 *
 *      Stream流：手段
 *      集合，才是目的
 *
 *      流：只能使用一次
 *
 */
public class StreamFinalMethod {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");
        Stream<String> zhanglists = list.stream().filter(s -> s.startsWith("张"));
        //把stream流转换成Set集合
        Set<String> sets=zhanglists.collect(Collectors.toSet());
        //转成对赢得Set集合之后，数据元素会自动去重
        System.out.println(sets);

        //把Stream转换成List集合
        Stream<String> zhanglists1 = list.stream().filter(s -> s.startsWith("张"));
        List<String> lists=zhanglists1.collect(Collectors.toList());
        System.out.println(lists);

        //把Stream流转换成数组
        Stream<String> zhanglists2 = list.stream().filter(s -> s.startsWith("张"));
//        Object[] strs= zhanglists2.toArray();

        //对应的转化为String[]
//        String[] arrs=zhanglists2.toArray(new IntFunction<String[]>() {
//            @Override
//            public String[] apply(int value) {
//                return new String[value];
//            }
//        });

        //如果要将Object[]转为String[]数组
        //简化过程
        String[] strings=zhanglists2.toArray(s->new String[s]);
//        String[] strings = zhanglists2.toArray(String[]::new);
        //遍历输出数组
        System.out.println("String类型数组："+ Arrays.toString(strings));
    }
}
