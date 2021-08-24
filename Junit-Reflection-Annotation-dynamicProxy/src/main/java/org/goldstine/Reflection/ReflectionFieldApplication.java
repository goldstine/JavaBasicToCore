package org.goldstine.Reflection;

import java.lang.reflect.Field;

/**
 * 反射获取成员变量的作用：取值和复制
 * Field的方法：给成员变量赋值和取值
 *      void set(Object obj,Object value);给对象注入某个成员变量数据
 *      Object get(Object obj);获取对象的成员变量的值
 *      void setAccessible(true);暴力反射，设置为可以直接访问私有类型的属性
 *      Class getType();获取属性的类型，返回Class对象
 *      String getName();获取属性名称
 */
public class ReflectionFieldApplication {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //首先获取对应的class对象
        Class<?> clazz = Dog.class;
        //通过clazz对象获取对应的成员变量
        Field name = clazz.getDeclaredField("name");

        //通过对应的api进行成员变量的设置,除了静态成员变量，其他的成员变量都属对象
        //所以先创建对应的对象，然后赋值

        //首先要将对应的权限打开
        name.setAccessible(true);
        Dog taidi = new Dog();
        /**
         * 参数一：被复制的对象
         * 参数二：该成员变量的值
         */
        name.set(taidi,"勇敢的泰迪");

        System.out.println(taidi);

        //注：实际中不会这样破坏封装性第为成员变量赋值，会通过反射获得对应的方法，通过setXXX()赋值

        //获取成员变量的值
        String s = (String)name.get(taidi);
        System.out.println(s);


    }
}
