package org.goldstine.SetDemo03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *Set集合：
 * 和ArrayList基本上没有拓展List的功能一样，HashSet也基本上没有拓展Set的功能，所以创建HashSet也基本上使用Set接收，体现多态
 * Set<String> sets=new HashSet<String>();
 *
 * set集合的遍历，有3种方式
 *
 */
public class SetDemo01 {
    public static void main(String[] args) {
        //测试HashSet
        Set<String> sets = new HashSet<String>();
        sets.add("杨幂");
        sets.add("古力娜扎");
        sets.add("江疏影");
        sets.add("迪丽热巴");

        //通过迭代器进行遍历
        Iterator<String> iterator = sets.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=================");
        //通过增强for循环进行遍历
        for (String set : sets) {
            System.out.println(set);

        }
        System.out.println("==================");
        //通过lambda方式进行遍历
        sets.forEach(s-> System.out.println(s));
        sets.forEach(System.out::println);
    }
}
