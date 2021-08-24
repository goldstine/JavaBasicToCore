package org.goldstine.CollectionsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Collections集合工具类：
 *      public static <T> void sort(List<T> list);
 *      将集合中的元素按照默认的规则排序
 *      如果希望自定义的引用类型排序不报错，可以给类提供比较规则Comparable
 *
 *      public static <T> void sort(List<T> list,Comparator<? super T>)
 *          将集合中元素按照制定规则排序，自带比较器
 *
 *          如果类有比较规则，而这里有比较器，优先使用比较器
 *
 *
 *
 *      </T>
 */
public class CollectionsDemo02 {
    public static void main(String[] args) {
        //自定义类型排序
        List<Orange> oranges=new ArrayList<>();
        Orange o1 = new Orange("红橘子", 654.0, "便宜。。。");
        Orange o2 = new Orange("黄橘子", 454.0, "便宜。。。");
        Orange o3 = new Orange("黄橘子", 454.0, "便宜。。。");
        Orange o4 = new Orange("青橘子", 456.0, "便宜。。。");
        Collections.addAll(oranges,o1,o2,o3,o4);
        Collections.sort(oranges);
        System.out.println(oranges);


        List<Orange> list=new ArrayList<>();
        Orange o11 = new Orange("红橘子", 654.0, "便宜。。。");
        Orange o22 = new Orange("黄橘子", 454.0, "便宜。。。");
        Orange o33 = new Orange("黄橘子", 454.0, "便宜。。。");
        Orange o44 = new Orange("青橘子", 456.0, "便宜。。。");
        Collections.addAll(list,o11,o22,o33,o44);
        Collections.sort(list, new Comparator<Orange>() {
            @Override
            public int compare(Orange o1, Orange o2) {
                if(o1.getWeight()>o2.getWeight()){
                    return 1;
                }else if(o1.getWeight()<o2.getWeight()){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(list);


        //简化写法
        System.out.println("==================");
        List<Orange> orangeList=new ArrayList<>();
        Orange o111 = new Orange("红橘子", 654.0, "便宜。。。");
        Orange o222 = new Orange("黄橘子", 454.0, "便宜。。。");
        Orange o333 = new Orange("黄橘子", 454.0, "便宜。。。");
        Orange o444 = new Orange("青橘子", 456.0, "便宜。。。");
        Collections.addAll(orangeList,o111,o222,o333,o444);
        Collections.sort(orangeList, ( o1111, o2222) ->{
                if(o1111.getWeight()>o2222.getWeight()){
                    return 1;
                }else if(o1111.getWeight()<o2222.getWeight()){
                    return -1;
                }
                return 0;
        });
        System.out.println(orangeList);


    }


}
