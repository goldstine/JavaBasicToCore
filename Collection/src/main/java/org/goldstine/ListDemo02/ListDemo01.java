package org.goldstine.ListDemo02;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合继承了Collection集合的全部功能，同时因为List系列集合有索引
 *  ArrayList实现类集合底层基于数组存储数据的，查询快，增删慢
 *      因为List集合多了索引，所以多了很多按照索引操作元素的功能
 *          public void add(int index,E element);将指定元素，添加到集合中的指定位置
 *          public E get(int index);返回集合中指定位置的元素
 *          public E remove(int index);移除列表中指定位置的元素，返回的是被移除的元素
 *          public E set(int index,E element);用指定元素替换集合中指定位置的元素，返回值的更新
 *
 *          ArrayList几乎相对于List接口，没有添加功能
 *          但是LinkedList作为List接口的实现类，添加了一些新的功能
 */
public class ListDemo01 {
    public static void main(String[] args) {

        //通过ArrayList可以模拟一个数组

        List<String> list = new ArrayList<>();//多态写法，List是接口父类，ArrayList是List接口的实现类
        list.add("java1");
        list.add("java1");
        list.add("java2");
        list.add("java2");

        list.add(0,"赵敏");//相当于数组的插入，原先的元素都进行后移操作

        System.out.println(list);//由于之前Collection就已经将toString()重写了，所以打印集合的内容

        //删除元素,remove删除元素返回被移除元素
        System.out.println(list.remove(0));
        System.out.println(list);

        System.out.println(list.get(0));

        System.out.println(list.set(2,"c++"));
        System.out.println(list);
    }
}
