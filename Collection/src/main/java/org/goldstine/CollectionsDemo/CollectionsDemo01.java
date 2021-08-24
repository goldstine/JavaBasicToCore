package org.goldstine.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections工具类使用
 *      java.util.Collections是集合工具类
 *      Collections不属于，是用来操作集合的工具类
 *          Collections有几个常用的api
 *              public static <T> boolean addAll(Collection<? super T>c,T... elements)
 *              给集合对象批量添加元素
 *              public static void shuffle(List<?> list):打乱集合顺序
 *              public static <T> void sort(List<T> list)将集合中元素按照默认排序规则排序  对List集合进行排序，默认按照升序排序
 *               public static <T> void sort(List<T> list,Comparator<? super T>);将集合中元素按照指定规则进行排序
 *
 */
public class CollectionsDemo01 {
    public static void main(String[] args) {
        //1、给集合批量添加元素
        Collection<String> names=new ArrayList<>();
        //参数一：被添加元素的集合
        //参数二：可变参数，一批元素
        Collections.addAll(names,"曹操","贾乃亮","王宝强","陈羽凡");

        System.out.println(names);

        //打乱集合的顺序
        //注意只能打乱List集合的顺序,Set集合还是会按照hashCode()%length
        List<String> newnames=new ArrayList<>();
        Collections.addAll(newnames,"曹操","贾乃亮","王宝强","陈羽凡");
        Collections.shuffle(newnames);
        System.out.println(newnames);
        //shuffle底层可以通过每次生成一个随机数，然后进行交换每一个元素与生成索引对应的元素值


        //给List集合升序排序
        List<Double> socres=new ArrayList<>();
        Collections.addAll(socres,98.5,66.5,59.5,99.5,66.5);
        Collections.sort(socres);//对List集合进行排序，默认按照升序排序
        System.out.println(socres);

    }
}
