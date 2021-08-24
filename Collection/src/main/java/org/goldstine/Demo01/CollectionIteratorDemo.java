package org.goldstine.Demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Collection集合的遍历方式：
 *      （1）迭代器
 *              public Iterator iterator();获取及和对应的迭代器，用来遍历集合中的元素的
 *              next()是获取下一个元素的值，
 *              hasNext()将迭代器向后移动一位
 *
 *      （2）foreach(增强for循环)
 *
 *          forEach是一种遍历形式：可以变量集合或者数组
 *          foreach遍历集合实际上是迭代器便利的简化写法
 *          foreach遍历的关键是记住格式
 *
 * foreach遍历方式，不知道遍历到哪一个元素，因为不知道遍历的索引，只能够从头到尾进行遍历
 *
 * Collection集合不能用for循环遍历，因为没有索引
 *
 *      (3)jdk1.8开始的新技术Lambda
 *
 *      (4)List集合可以通过for循环的索引遍历集合
 *
 *
 */
public class CollectionIteratorDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();//有序，可重复，有索引

        list.add("赵敏");
        list.add("周芷若");
        list.add("殷素素");
        list.add("小昭");

        //获取对应的迭代器对象
        Iterator<String> iterator = list.iterator();

//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
////        System.out.println(iterator.next());//NoSuchElementException
//        System.out.println(iterator.next());

        //通过while(iterator.hasNext())进行集合的遍历
        while(iterator.hasNext()){
            String ele = iterator.next();
            System.out.println(ele);
        }
        System.out.println("==========foreach遍历方式==========");
        //foreach的方式遍历集合
        for (String obj:list) {
            System.out.println(obj);
        }

        //foreach遍历方式对应idea快捷键


        //lambda便利的方式
        list.forEach(s-> System.out.println(s));
        //简化写法
        System.out.println("========简化写法=========");
        list.forEach(System.out::println);
    }
}
