package org.goldstine.bufferIO;

import java.io.*;

/**
 * 缓冲流：
 *      BufferedInputStream    BufferedOutputStream   BufferedReader   BufferedWriter
 *      缓冲流可以提高字节流和字符流的读写数据性能
 *
 *      缓冲流分四类：
 *      BufferedInputStream   字节缓冲输入流   可以提高字节输入流读数据的性能能
 *      BufferedOutputStream   字节缓冲输出流  可以提高字节输出流的写数据性能
 *      BufferedReader         字符缓冲输入流          可以提高字符输入流读数据的性能能
 *      BufferedWriter          字符缓冲输出流      可以提高字符输出流的写数据性能
 *
 *      字节缓冲输入流 BufferedInputStream
 *          作用：可以将低级的字节输入流包装成一个高级的缓冲字节输入流管道
 *              从而提高字节输入流读数据的性能
 *           构造器：
 *           public BufferedInputStream(InputStream in)
 *
 * 小结：
 *      缓冲字节输入流管道自带了一个8KB的缓冲池，每次可以直接借用操作系统的功能最多读取8KB
 *      的数据到缓冲池中去，以后直接从缓冲池读取数据，性能较好
 *
 *      为了解决内存和磁盘之间的速度不匹配问题，减少了IO次数
 */
public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo01.txt");

        //通过缓冲输入流进行包装
        BufferedInputStream bis = new BufferedInputStream(is);


        //通过字节输入流循环读取
        byte[] buffer=new byte[1024];
        int len;
        while((len=bis.read(buffer))!=-1){
            String s = new String(buffer);
            System.out.print(s);
        }
    }
}
