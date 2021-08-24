package org.goldstine.bufferIO;

import java.io.*;

/**
 * 字符缓冲流BufferedReader
 *      作用：字符缓冲流可以把字符输入流包装成一个高级的缓冲字符输入流
 *      可以提高字符输入流读数据的性能
 *
 *      构造器：public BufferedReader(Reader reader);
 *      原理：缓冲字符输入流默认会有一个8K的字符缓冲池，可以读字符的性能
 *
 *      还多了一个按照行读取数据的功能
 *      public String readLine();读取一行数据返回，读取完毕返回null
 *
 *
 * //都文本文件经典代码：通过FileReader====>包装成BufferedReader
 * String line;
 *         //使用循环读取
 *         while((line=bufferedReader.readLine())!=null){
 *             System.out.println(line);
 *         }
 *按照行读：可以提高性能，如果按照桶读，可能会有粘包和半包问题
 * 所以对应的一些配置文件通常都是一行一行配置，然后一行一行读取
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo01.txt");

        //通过包装流优化性能，减少IO
        BufferedReader bufferedReader = new BufferedReader(reader);

        //通过字符流读数据   （1）读一个字符（2）读一个字符数组

        //创建一个字符数组
//        char[] buffer=new char[1024];
//
//        //创建一个变量
//        int len;
//        while((len=bufferedReader.read(buffer))!=-1){
//            //将字符数组转成字符串
//            String s = new String(buffer,0,len);//通过String()也可以指定长度
//            System.out.println(s);
//        }


        //多路一个按照行读的方法，所以不建议通过while读取

//        System.out.println(bufferedReader.readLine());
//        System.out.println(bufferedReader.readLine());


        //使用readLine()和循环读取

        String line;
        //使用循环读取
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }


        reader.close();
    }
}
