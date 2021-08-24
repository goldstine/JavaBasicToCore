package org.goldstine.objectclass;

import java.util.Objects;

/**
 * Objects还是Object类的子类
 *      Objects类是从jdk1.7开始之后才有的
 *
 *      Objects的方法：
 *          （1）public static boolean equals(Object a,Objectb);
 *                  比较两个对象
 *                  底层进行非空判断，从而可以避免空指针异常，更安全
 *
 *           （2）public static boolean isNull(Object obj);
 *                  判断变量是否为null,为null返回true,反之
 */
public class ObjectsDemo {
    public static void main(String[] args) {
        Student student = null;
        Student student1 = new Student();

        System.out.println(Objects.equals(student,student1));
//        System.out.println(student.equals(student1));

        //isNull()询问是否为null对象
        System.out.println(Objects.isNull(student));
        //等价于
        System.out.println(student==null);
    }
}
