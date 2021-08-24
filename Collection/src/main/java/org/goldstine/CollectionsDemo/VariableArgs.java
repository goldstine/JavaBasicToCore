package org.goldstine.CollectionsDemo;

import java.util.Arrays;

/**
 * 可变参数：
 * 传输参数非常灵活·：
 *      可以不传输参数
 *      可以传输一个参数
 *      可以传输多个参数
 *      可以传输一个数组
 *
 *      可变参数在方法内部本质就是一个数组
 *      可变参数的注意事项：
 *          （1）一个形参列表中可变参数只能有一个
 *          （2）可变参数必须放在形参列表的最后
 */
public class VariableArgs {
    public static void main(String[] args) {
        sum();//可以不传参数
        sum(10);
        sum(10,20,30);
        sum(new int[]{10,30,50,70,90});
    }

    public static int sum(int... a){
//可变参数在方法内部本质上就是一个数组
        System.out.println("元素个数:"+a.length);
        System.out.println("元素内容："+ Arrays.toString(a));
        for (int i : a) {
            System.out.println(i);

        }

        return 0;
    }
}
