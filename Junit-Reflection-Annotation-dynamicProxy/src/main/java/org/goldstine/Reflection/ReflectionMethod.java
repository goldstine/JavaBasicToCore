package org.goldstine.Reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：获取method方法对象
 *
 *  反射获取类的method方法对象
 *      (1)Method getMethod(String name,Class... args):根据方法名和参数类型获得对应的方法对象，只能获得public的
 *      (2)Method getDeclaredMethod(String name,Class... args):根据方法名和参数类型获得对应的方法对象，包括private
 *      (3)Method[] getMethods();获得类中所有的成员方法对象，返回数组，只能获得public修饰的且包含父类的
 *      (4)Method[] getDeclaredMethods():获得类中所有的成员方法对象，返回数组，只获得本类中声明的方法
 *
 * Method对象方法：
 *      Object invoke(Object obj,Object... args):
 *      参数一：触发的是哪个对象的方法执行
 *      参数二：args,调用方法是传递的实际参数
 *
 *
 */
public class ReflectionMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //首先获得对应的class对象
        Class<?> clazz = Dog.class;
        //通过class对象获得对应的所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName()+"====>"+declaredMethod.getReturnType());

        }

        System.out.println("======================");

        //获得所有的public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+"=====>"+method.getReturnType());
        }

        System.out.println("======================");
        //获得对应的某一个方法
        Method getName = clazz.getMethod("getName");
        System.out.println(getName.getName()+"====>"+getName.getReturnType());

        /**
         * private String name;
         *     private int age;
         *     private String color;
         *     public static String school;
         *     public static final String SCHOOL_1="宠物学校";
         */

        //通过invoke(对象名，参数列表)执行某一个方法
        //首先创建一个对象,
        Dog taidi = new Dog("doger",12,"黄色");

        String rs = (String)getName.invoke(taidi);
        System.out.println(rs);

        //反射中方法如果没有返回值，也可以通过Object进行接收
    }
}
