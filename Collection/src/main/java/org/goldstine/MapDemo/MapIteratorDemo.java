package org.goldstine.MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历方式：
 *      （1）键找值的方式遍历，先获取map集合所有的键，再根据键找值
 *      （2）键值对的方式遍历
 *      （3）JDK1.8开始的新技术  Lambda表达式
 *
 *      键值对的方式：
 *          （1）先获取所有的键Set集合
 *          （2）遍历键的Set集合，然后通过键找值
 *
 *      通过键值对的方式遍历：更加面向的对象的方式
 *          （1）把Map集合转换成一个Set集合：Set<Map.Entry<K,V>> entrySet
 *          (2)此时键值对元素的类型就确定下来了，类型是键值对实体类型  Map.Entry<K,V>
 *              (3)接下来就可以通过foreach遍历这个Set集合，类型用Map.Entry<K,V>
 *
 *       Lambda表达式遍历
 *       直接通过k,v进行遍历
 *       maps.forEach((k,v)->{System.out.println(k+"===>"+v);});
 */
public class MapIteratorDemo {
    public static void main(String[] args) {
        Map<String ,Integer> maps=new HashMap<>();
        maps.put("娃娃",30);
        maps.put("iPhone",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);

        //首先获取所有的键
        Set<String> strings = maps.keySet();
        for (String string : strings) {
            System.out.println(string+"="+maps.get(string));

        }


        //通过键值对进行遍历
        //首先转为entrySet类型
        Set<Map.Entry<String, Integer>> entries = maps.entrySet();
        //将<String,Integer>包装成一个整体Map.Entry<String,Integer>作为一个整体数据类型，相当于定义的一个结构体，
        //该结构体提供一个getKey(),getValue()方法分别获得随对应的键和值
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"==>"+entry.getValue());
        }

        System.out.println("=========通过lambda遍历==========");
        //通过lambda表达式进行遍历
        maps.forEach((k,v)->{System.out.println(k+"==>"+v);});
    }
}
