package org.goldstine.IOdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * FileWriter字符输出流
 * 作用：以内存为基准，把内存中的数据按照自负的形式写出到磁盘文件中去
 *      简单来说，就是把内存的数据以字符写出到文件中去
 *      构造器：
 *      public FileWriter(File file):创建一个字符输出流管道通向目标文件对象
 *      public FileWriter(String filePath);创建一个字符输出流管道通向目标文件路径
 *      public FileWriter(File file,boolean append);创建一个字符输出流管道通向目标文件路径
 *      public FileWriter(String filePath,boolean append);创建一个字符输出流管道通向目标文件路径
 *
 *      方法：
 *          public void write(int c);写一个字符出去
 *          public void write(String c);写一个字符串出去
 *          public void write(char[] buffer)；写一个字符数组出去
 *          public void write(String c,int pos,int len);写字符串的一部分出去
 *          public void write(char[] buffer,int pos,int len);写一个字符数组的一部分出去
 */
public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
       Writer fw = new FileWriter("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo01.txt");

       //写一个字符出去
       fw.write(97);
       //写一个字符
        fw.write('b');
        fw.write('磊');

        //写一个字符串出去
        fw.write("java是最优秀的语言");

        //写一个字符数组
        fw.write(new char[]{'我','爱','中','国'});
        //字符串有对应的将字符串转为字符数组的方法   toCharArray()
        fw.write("我爱中国国".toCharArray());
        /**
         * 字符串对应的将字节数组，字符数组通过构造器转为对应的字符串
         * new String(buffer{字节数组，字符数组})
         * 字符串将字符串转为对应的字节数组，字符数组
         * "1212".getBytes()
         * "wewe".toCharArray()
         *
         */

        //将字符串的一部分写出去
        fw.write("通俗易懂，体系化，结构化",0,5);

        //将换行写出去
        fw.write("\r\n");

        //将字符数组的一部分写出去
        fw.write("c++写起来也很舒服".toCharArray(),0,5);


        //创建追加字符流管道
        Writer fw1 = new FileWriter("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo01.txt",true);

        fw1.write("goldstine".toCharArray());
//        fw1.flush();

//        fw.flush();
        fw.close();//关闭包含刷新
        fw1.close();
    }
}
