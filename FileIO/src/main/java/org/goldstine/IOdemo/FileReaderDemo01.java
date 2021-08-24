package org.goldstine.IOdemo;

import java.io.*;

/**
 * FileReader:文件字符输入流
 *  作用：以内存为基准，把磁盘文件的数据以字符的形式读入到内存
 *  简单来说，读取文本文件内容到内存中
 *  构造器：
 *      public FileReader(File file):创建一个字符输入流与源文件对象接通
 *      public FileReader(String filePath):创建一个字符输入流与原文件路径接通
 *
 *   方法：
 *      public int read();读取一个字符的编号返回，读取完毕之后返回-1
 *      public int read(char[] buffer):读取一个字符数组，读取多少个字符就返回多少个数量
 *
 * 小结：字符流一个一个字符地读取文本内容输出，可以解决中文读取输出乱码的问题
 * 字符流很适合操作文本文件内容
 * 但是，一个一个字符地读取文本内容性能较差
 *
 */
public class FileReaderDemo01 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt");
        //创建一个字符输入流
        Reader fr = new FileReader(file);

        //按照字符读取，每次读取一个字符的编号返回
//        int code1 = fr.read();  //返回的都是每一个字符对应的ascii码编号
//        System.out.println((char)code1);
//
//        int code2=fr.read();
//        System.out.println((char)code2);
//
//        int code3=fr.read();
//        System.out.println((char)code3);

        //通过循环的方式读取
        //创建一个变量存储每一个字符的编号
//        int ch;
//        while((ch=fr.read())!=-1){
//            System.out.println((char)ch);
//        }

        //通过字符数组读取文本文件
//        //创建一个字符数组
//        char[] buffer=new char[3];
//        int len=fr.read(buffer);
//        System.out.println("字符数："+len);
//        //字符串存在构造方法直接将字符数组转为字符串
//        String s = new String(buffer);
//        System.out.println(s);


        //通过字符数组循环读取
        char[] buffer=new char[1024];
        int len;
        while((len=fr.read(buffer))!=-1){
            String s = new String(buffer, 0, len);
            System.out.print(s);
        }
    }
}
