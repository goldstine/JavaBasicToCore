package org.goldstine.serialize;

import java.io.*;

/**
 *对象的反序列化（对象字节输入流）ObjectInputStream
 * 作用：读取序列化的对象文件恢复到java对象中
 * 构造器：public ObjectInputStream(InputStream is)
 * 方法：public final Object readObject()
 *
 * 如果bean的一个字段不想参与序列化：
 *      可以通过transient修饰该成员变量，他将不参与序列化
 *序列化版本号：
 *      //加入序列版本号
 *      private static final long serialVersionUID=2L;
 *      必须序列化使用的版本号盒饭序列化使用的版本号一致才可以正常序列化，否则报错
 *
 */
public class SerializeDemo02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //定义一个低级的字节输入流通向源文件
        InputStream fis = new FileInputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.dat");

        //将低级流包装成一个对象输入流
        ObjectInputStream ois = new ObjectInputStream(fis);

        //通过对象输入流读取对应的序列化之后的对象
        User o = (User)ois.readObject();

        System.out.println(o);
    }

}
