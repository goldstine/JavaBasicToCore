package org.goldstine.bufferIO;

import java.io.*;

/**
 * 字符输出转换流：OutputStreamWriter
 *      作用：可以指定编码将字节输出流转换成字符输出流
 *      可以指定写出去的字符的编码
 *
 *      构造器：
 *          public OutputStreamWriter(OutputStream os):用当前默认编码UTF-8把字节输出流转为字符输出流
 *          public OutputStreamWriter(OutputStream os,String charset):
 *
 *   小结：
 *      字符输出转换流可以指定编码把字节输出流转换成字符输出流
 *      从而实现指定写出取得字符编码
 */
public class OutputStreamWriterDemo {

    public static void main(String[] args) throws IOException {
        OutputStream fos = new FileOutputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo03.txt");
        //把字节输出流转换成字符输出流
        Writer outputStreamWriter = new OutputStreamWriter(fos,"GBK");
        outputStreamWriter.write("abc我是中国人");
        outputStreamWriter.close();
    }
}
