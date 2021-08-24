package org.goldstine.serialize;

import java.io.*;

/**
 * 对象的序列化与反序列化，系统的单点登录
 *
 * 对象序列化：就是把java对象数据直接存储到文件中去    对象====》文件
 * 对象反序列化：就是把java对象的文件数据恢复到java对象中    文件===》对象
 *
 *
 * ObjectInputStream    ObjectOutputStream
 *
 * 对象序列化流（对象字节输出流）ObjectOutputStream
 *      作用：把内存中的java对象数据保存到文件中去
 *      构造器：public ObjectOutputStream(OutputStream out);
 *
 *      序列化方法：public final void writeObject(Object obj);
 *
 *      //注意：
 *      对象如果需要序列化，必须实现Serializable接口
 */

public class SerializeDemo01 {
    public static void main(String[] args) throws IOException {
        //创建一个对象
        User user = new User("铁扇公主", "123434", "goldstine");
        //创建低级的字节输出流通向目标文件
        OutputStream fos = new FileOutputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.dat");
        //把低级的字节输出流包装成高级的对象字节输出流ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        //通过对象字节输出流序列化对象
        objectOutputStream.writeObject(user);
        //释放资源，一般将包装之后的流关闭，关闭最外边的资源
        objectOutputStream.close();
        System.out.println("序列化成功！");



    }

}
