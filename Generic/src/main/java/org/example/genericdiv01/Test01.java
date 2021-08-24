package org.example.genericdiv01;

import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) {
        Infoimpl infoimpl = new Infoimpl();
        Class<? extends Infoimpl> clazz = infoimpl.getClass();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName()+":"+declaredMethod.getReturnType().getSimpleName());
        //info:Integer
            //info:Object  桥接方法
            // 有两个方法
        }


    }
}
