package org.goldstine.IOdemo;

import java.io.*;

/**
 * 通过字节数组循环读取
 *
 * 小结：
 *      使用字节数组读取内容，效率可以
 *        但是使用字节数组读取文本内容输出，也无法避免中文读取输出乱码问题
 *
 * 采用一个一个字节读取中文输出
 * 一个一个字节数组读取中文输出均无法避免乱码
 *
 * 如何实现读取可以避免乱码
 * 使用字符流
 *      （1）定义一个字节数组与文件大小一样大，然后一桶水读取全部字节数据再输出 =====>问题：对于大文件不可用
 *              sun公司的api也提供了这个方法 jdk1.9
 *                  byte[] buffer=ins.readAllBytes();
 *                  String s=new String(buffer);
 *                  System.out.println(s);
 *      小结：定义一个字节数组与文件大小一样大，然后一桶水读取全部字节数据再输出
 *      可以避免中文读取输出乱码，但是如果读取的文件过大，会出现内存溢出
 *
 *      字节流并不适合读取文本文件内容输出，读写文件内容建议使用字符流
 *      字节流适合做文件的通信转移复制，不适合文本文件的读取
 */
public class FileInputStreamRead {

    public static void main(String[] args) throws IOException {
//        InputStream ins = new FileInputStream("D:\\\\Goldstine_workspace\\\\JavaDevelopment\\\\SpringBoot\\\\JavaCore\\\\FileIO\\\\src\\\\main\\\\java\\\\org\\\\goldstine\\\\filedemo.txt");
//        //通过循环的方式读取到字节数组
//        //创建一个字节数组
//        byte[] buffer=new byte[3];
//        //记录没一次读取的数据是否为-1
//        int len=0;
//        //循环读取
//        while((len=ins.read(buffer))!=-1){
//            //将每次读取的桶buffer中的字节数组转为字符串
//            String s = new String(buffer, 0, len);
//            System.out.print(s);
//        }
//
//        //还是会出现乱码问题 当文本文件为：abcxy我爱罗第二桶水的时候会出现乱码


        //乱码方案一、
        //获取文件对象
        File file=new File("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt");
        InputStream ins = new FileInputStream(file);
        //定义一个字节数组与文件的大小一样大
//        byte[] buffer=new byte[(int)file.length()];//file.length()返回的是long类型的数据，byte是在内存中开辟一块内存空间，
//        int len=ins.read(buffer);
//        String s = new String(buffer, 0, len);
//        System.out.println(s);
        //等价于下面的api 1.9
//        readAllBytes();


    }
}
