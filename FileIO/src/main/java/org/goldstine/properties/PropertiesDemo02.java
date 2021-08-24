package org.goldstine.properties;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Properties读取属性文件中的键值对信息
 *      方法：
 *          public synchronized void load(InputStream inStream);加载属性文件的数据到字节输入流
 *
 *          public synchronized void load(Reader fr);加载属性文件的数据到字符输入流
 *
 */
public class PropertiesDemo02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //将属性文件数据读到输入字节流
        InputStream fis = new FileInputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\user.properties");

        //读取属性文件
//        properties.load(fis);

        //通过字符流读取
        Reader fr = new FileReader("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\user.properties");

        properties.load(fr);

        //将数据读入对应的properties对象中

        //输出对应的数据
        System.out.println(properties.stringPropertyNames());

        //还是要理解对应的properties是一个集合容器，所以数据都读到properties中去了
        //遍历map集合的3种方式
        //方式一：通过键获取值
        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            System.out.println(string+"===>"+ properties.getProperty(string));
        }

        //方式二：通过entrySet的方式
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey()+"====>"+entry.getValue());
        }

        //方式三：通过lambda
        properties.forEach((k,v)-> {System.out.println(k+"====>"+v);});


        fis.close();
        fr.close();
    }
}
