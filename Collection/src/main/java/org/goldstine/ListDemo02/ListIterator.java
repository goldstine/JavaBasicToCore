package org.goldstine.ListDemo02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List集合可以通过索引方式进行遍历
 *
 */
public class ListIterator {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Java1");
        list.add("java1");
        list.add("java2");

        //通过for循环进行遍历
        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }
        
        //通过迭代器遍历
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }

        //foreach遍历
        for (String s : list) {
            System.out.println(s);
        }

        //lambda遍历方式
        list.forEach(s-> System.out.println(s));
        list.forEach(System.out::println);
    }

}
