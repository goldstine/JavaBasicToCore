package org.goldstine.MapDemo;

import java.util.LinkedHashMap;

/**
 * 前面讲了HashMap，作为Map的嫡长子HashMap,两者之间的方法基本上是一致的
 *
 * LinkedHashMap:是HashMap的子类
 *      添加的元素按照键有序，不重复
 *      HashSet集合相当于是HashMap集合的键都不带值
 *      LinkedHashSet相当于是LinkedHashMap集合的键都不带值
 *
 *      底层原理都一样，都是基于哈希表按照键存储数据的
 *      只是HashMap或者LinkedHashMap的键都多一个附属值
 *
 *
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> maps=new LinkedHashMap<>();
        maps.put("zhangsan",12);
        maps.put("lishi",23);
        maps.put("wangwu",24);
        maps.put("zhangsan",34);//为了保证有序，键重复的元素直接将先加入的元素进行覆盖

        System.out.println(maps);
    }
}
