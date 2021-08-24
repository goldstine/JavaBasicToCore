package org.goldstine.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Junit框架的注解
 * 自定义注解模拟写一个Junit框架的基本使用
 *      定义若干个方法，只要加了MyTest注解
 *      就可以被自动触发执行
 *
 *      分析：（1）定义一个自定义注解TestMy
 *              只能注解方法，存活范围一直都在
 *              （2）定义若干个方法，只要有@TestMy注解的的方法就能被触发执行
 *              没有这个注解的方法不能执行
 *
 */
public class JunitAnnotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        JunitAnnotation obj = new JunitAnnotation();

        //通过测试类的启动按钮，实现哟注解标记的方法就要出发执行
        Class clazz = JunitAnnotation.class;
        //获得所有的方法对象
        Method[] methods = clazz.getDeclaredMethods();

        //对所有的方法进行遍历
        for (Method method : methods) {
            //对于有对应的注解的方法进行执行
            if(method.isAnnotationPresent(TestMy.class)){
                //调用该方法
                method.invoke(obj);
            }
        }
    }

    //定义若干个方法
    @TestMy
    public void run(){
        System.out.println("========run=======");
    }
    @TestMy
    public void show(){
        System.out.println("=======show========");
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestMy{

}