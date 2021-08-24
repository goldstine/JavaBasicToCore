package org.goldstine.Reflection.application;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class Mybatis {
    //提供一个方法，可以保存一切对象数据的字段和具体值
    public static void save(Object obj){

        try(
                PrintStream ps = new PrintStream(new FileOutputStream("D:\\goldstine\\goldstine.txt",true),true);

                ) {
            //解析对象的字段和每个字段的值存储起来
//        对应的save(参数可以各种数据类型，所以通过反射机制获得对应的对象解析数据)
            //首先获得对应的对象的class文件对象
            Class<?> clazz = obj.getClass();

            ps.println("========"+clazz.getSimpleName()+"============");
            //定位他的全部成员变量
            Field[] fields = clazz.getDeclaredFields();

            //遍历这些字段并且取值
            for (Field field : fields) {
                //字段名称
                String name = field.getName();
                //设置为对应的权限
                field.setAccessible(true);
                //字段的值
                String value = field.get(obj) + "";
                //通过打印流将数据存储到对应的文件中
                ps.println(name+"="+value);
            }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

}
