package org.goldstine.MapDemo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap集合：
 *TreeSet的底层是基于TreeMap     都通过红黑树进行排序
 *
 *TreeMap集合按照键是可排序不重复的键值对集合（默认升序）
 *TreeMap集合按照键排序的特点与TreeSet是完全一样的
 *
 * 小结：
 * TreeMap集合和TreeSet集合都是排序不重复集合
 * TreeSet集合的底层是基于TreeMap,只是见没有附属值而已
 * 所以TreeMap集合指定大小规则有2种方式
 *      （1）直接为对象的类实现比较器规则接口Comparable,重写比较方法
 *      （2）直接为集合设置比较器Comparator对象，重写比较方法
 *
 *测试TreeMap不需要重写hashCode()和equals()方法，会自动将自定义对象去重，但是还是建议要将内容相同的TreeMap元素去重，
 * 就重写对应的hashCode()和equals()
 *
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> maps = new TreeMap<>();
        maps.put(1000000,"张三");
        maps.put(1000000,"张三1");
        maps.put(10000,"李四");
        maps.put(10,"王五");
        maps.put(24244,"张麻子");

        System.out.println(maps);

        //自定义数据类型的排序
        //通过比较规则进行排序
        Map<Pig,String> pigs=new TreeMap<>();
        pigs.put(new Pig("佩奇",99.5,500.0),"荷兰");
        pigs.put(new Pig("乔治",99.4,605.0),"荷兰");
        pigs.put(new Pig("野猪",199.5,300.0),"荷兰");
        System.out.println(pigs);

        //自定义数据类型的排序
        //通过比较器进行排序
        Map<Pig,String> pigs1=new TreeMap<>(new Comparator<Pig>() {
            @Override
            public int compare(Pig o1, Pig o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        });
        pigs1.put(new Pig("佩奇",99.5,500.0),"荷兰");
        pigs1.put(new Pig("乔治",99.4,605.0),"荷兰");
        pigs1.put(new Pig("野猪",199.5,300.0),"荷兰");
        pigs1.put(new Pig("野猪",199.5,300.0),"荷兰");
        System.out.println(pigs1);
    }
}
