package org.goldstine.lambda.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * Stream流的获取
 */
public class StreamGenerator {
    public static void main(String[] args) {
        //Collection集合获取流
        Collection<String> c=new ArrayList<>();
        Stream<String> stream = c.stream();//获得对应的Stream数据类型，每一个数据元素根据泛型确定为String

        //Map集合获取流
        Map<String,Integer> maps=new HashMap<>();
       // maps.keySet();以及maps.values()实际获得的都是Set集合，属于Collection的实现类，所以通过.stream()获得对应的流
        Stream<String> keys = maps.keySet().stream();
        Stream<Integer> values = maps.values().stream();
        //对应的entrySet其实也是一个集合
//        Set<Map.Entry<String, Integer>> entries = maps.entrySet();
        Stream<Map.Entry<String, Integer>> keyAndValues = maps.entrySet().stream();

        //数组获取流
        //数组也有Stream流
        //获取数组的流有两种方式
        String[] arrs = new String[]{"Java", "JavaEE", "Spring Boot"};
        //通过数组工具类获取数组流
        Stream<String> stream1 = Arrays.stream(arrs);
        //通过Stream的of()方法获得流
        Stream<String> stream2 = Stream.of(arrs);

    }
}
