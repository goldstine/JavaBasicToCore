package org.goldstine.lambda.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 什么是Stream
 *      在java8中，得益于lambda所带来的函数式编程
 *      引入一个全新的Stream流概念，用于解决已有集合/数组类库既有的弊端
 *
 *      Stream能解决问题
 *          可以解决已有集合类或者数组api的弊端
 *          Stream认为集合和数组操作的API不好用，所以采用Stream流简化集合和数组的操作
 *
 * Stream其实就是一根传送带，数据在传送带上传输
 *
 */
public class StreamDemo01 {
    public static void main(String[] args) {
        //需求：从集合中筛选出所有姓张的人出来，然后找出姓名长度是3的人
        List<String> list= new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //首先将所有的姓张的人找出来
//        List<String> zhanglist=new ArrayList<>();
//        for (String s : list) {
//            if (s.startsWith("张")) {
//
//                zhanglist.add(s);
//            }
//        }
//        System.out.println(zhanglist);
//
//        //在创建一个集合存放所有长度为3的姓张的人
//        List<String> zhangThreeList=new ArrayList<>();
//        for (String s : zhanglist) {
//            if(s.length()==3){
//                zhangThreeList.add(s);
//            }
//        }
//        System.out.println(zhangThreeList);

        //通过Stream简化之后
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);
        //首先将集合list转为Stream()像水流一样输出，然后通过filter()进行过滤，通过多个filter()条件进行过滤

//        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3);//返回值还是Stream()数据类型

    }

}
