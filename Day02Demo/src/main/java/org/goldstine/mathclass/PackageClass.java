package org.goldstine.mathclass;

/**
 * 包装类：
 * java认为一切皆对象，引用数据类型都是对象
 * 但是再java8基本数据类型不是对象，只是一种数据的类型形式
 * java为了一切皆对象的思想统一，把8种基本数据类型转换成对应的类，这个类称为基本数据类型的包装类
 *
 *
 *      自动装箱：可以直接把基本数据类型的值或者变量赋值给包装类
 *      自动拆箱：可以把包装类的变量直接赋值给基本数据类型
 *      作用，包装类  引用数据类型可以为null,所以相比较于基本数据类型容错能力更强
 */
public class PackageClass {
    public static void main(String[] args) {
        Integer b=2;
        int a=b;


        char s='s';
        Character ss=s;

        System.out.println("-=======");
        Integer it=Integer.valueOf(12);//手工装箱
        Integer integer = new Integer(12);//手工装箱

        //手动拆箱
        Integer it3=111;
        int it1=it3.intValue();//手工拆箱


    }
}
