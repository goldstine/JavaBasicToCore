package org.goldstine.Reflection;

import java.lang.reflect.Field;

/**
 * 反射获取成员变量
 * （1）Field getField(String name);根据成员变量名获得对应的Field对象，只能获得public修饰的成员变量
 * （2）Field getDeclaredField(String name);根据成员变量名获得对应的Field,只要声明了就可以获得
 * （3）Field[] getFields();
 * 获得所有的成员变量对应的Field对象，只能获得public的
 * （4）Field[] getDeclaredFields();获得所有的成员变量对应的Field对象，只要声明了就可以获得
 */
public class ReflectionField {
    public static void main(String[] args) throws NoSuchFieldException {
        //首先获得对应的class对象
        Class clazz = Dog.class;
        //获得对应的所有的成员变量对应的Fields
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()+"=====>"+declaredField.getType());
        }

        //可以发现，对于静态成员变量和常量都是成员变量


        //获得所有的成员变量public
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName()+"========>"+field.getType());
        }

        //获得某一个成员变量
        System.out.println(clazz.getField("school"));//只能拿到public的成员变量

        //获得任意的成员变量，实例成员变量，静态成员变量和常量

        System.out.println(clazz.getDeclaredField("name"));

    }
}
