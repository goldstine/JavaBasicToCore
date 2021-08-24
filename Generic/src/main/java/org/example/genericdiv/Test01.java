package org.example.genericdiv;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) {
        //通过反射获取类型擦除之后的泛型对应的类型
        Erasure<Integer> erasure=new Erasure<>();
        //通过对象获取对应的字节码文件
        Class<? extends Erasure> clazz = erasure.getClass();
        Field[] fields = clazz.getDeclaredFields();//获得所有的私有的和公有的成员变量

        for (Field field : fields) {
            System.out.println(field.getName()+":"+field.getType().getSimpleName());
        }

        //通过反射获取所有的方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //打印方法名和方法的返回值类型
            System.out.println(declaredMethod.getName()+":"+declaredMethod.getReturnType().getSimpleName());

        }
    }
}
