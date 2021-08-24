package org.goldstine.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Properties的概述和使用   保存数据到属性文件
 *
 * Properties属性集对象
 *      其实就是一个Map集合，也就是一个键值对集合，但是一般不会当集合使用，因为有HashMap
 *
 *      Properties核心作用：
 *      Properties代表的是一个属性文件
 *
 * Properties对象方法：
 *      public Object setProperty(String  key,String value);保存一对属性
 *      public String getProperty(String key):根据对应的属性列表中指定的键搜索属性值
 *      public Set<String> stringPropertyNames();所有键的名称的集合
 *      public void store(OutputStream out,String comments):保存数据到属性文件
 *      public void store(Write fw,String comments);保存数据到属性文件中去
 *
 *
 */
public class PropertiesDemo01 {
    public static void main(String[] args) throws IOException {
//        Map properties = new Properties();  Properties继承自HashTable
        Properties properties = new Properties();
        //设置对象，底层还是用过map的put()
        properties.setProperty("admin","123456");
        properties.setProperty("goldstine","1212");
        System.out.println(properties);

        //根据对应的键获得对应的属性值
        System.out.println(properties.getProperty("admin"));

        //获取所有的键
        Set<String> strings = properties.stringPropertyNames();
        strings.forEach(System.out::println);

        //把属性及对象的数据存入到属性文件中去
        //首先创建对应的字节输出流
        //第二个参数comments:表示保存数据的解释说明
        OutputStream fos = new FileOutputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\user.properties");
        properties.store(fos,"第一次保存");

    }
}
