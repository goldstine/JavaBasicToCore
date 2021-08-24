package org.goldstine.lambda.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法引用
 *      方法引用：方法引用是为了进一步简化lambda表达式的写法
 *      方法引用的格式，  类型或者对象::引用的方法
 *      关键语法是"::"
 */
public class MethodDemo01 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("java1");
        list.add("java2");
        list.add("java3");
        //遍历的简化写法
        list.forEach(s->System.out.println(s));
        //通过方法引用进一步进行lambda表达式的简化
        list.forEach(System.out::println);
    }
}
