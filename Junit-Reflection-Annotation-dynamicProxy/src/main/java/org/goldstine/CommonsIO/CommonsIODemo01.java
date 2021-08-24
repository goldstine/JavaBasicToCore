package org.goldstine.CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Commons-io包的使用
 * commons-io是apache开源的基金组织提供的椅子有关IO操作的类库
 * 可以提高IO功能开发的效率，commons-io工具包提供了很多有关io操作的类
 *包：
 *      org.apache.commons.io    有关Streams,Reader,Writers,File的
 *      org.apache.commons.io.input   输入流相关的实现类包含 Reader和InputStream
 *      org.apache.commons.io.otuput   输出流相关的实现类  Writer 和outputStream
 *      org.apache.commons.io.serialization  序列化相关的类
 *
 *      步骤：
 *          IOUtils和FileUtils可以方便的复制文件和文件夹
 *
 * commons-io提供了一个工具类org.apache.commons.io.IOUtils，封装了大量IO读写操作的代码，其中有两个常用方法
 * public static int copy(IntputStream in,OutputStream out)把input输入流中的内容拷贝到output输出流中，返回拷贝的字节个数（适合文件大小2GB以下）
 * public static long copyLarge(inputStream in ,OutputStream out)把input输入流中的内容拷贝到output输出流中，返回拷贝的字节个数（适合文件大小为2GB）
 *
 *
 */
public class CommonsIODemo01 {
    public static void main(String[] args) throws IOException {
        //通过IOUtils一行代码完成文件的复制，复制直接使用输入输出字节流即可
//        int copy = IOUtils.copy(
//                new FileInputStream("C:\\Users\\15797\\Desktop\\0.png"),
//                new FileOutputStream("D:\\goldstine\\1.png")
//        );
        //通过FileUtils一行代码完成文件夹复制:
        //将文件复制到文件夹
//        FileUtils.copyFileToDirectory(new File("D:\\goldstine\\1.png"),new File("D:\\goldstine\\test"));

        //将文件夹复制到另一个文件夹中
//        FileUtils.copyDirectoryToDirectory(new File("C:\\Users\\15797\\Desktop\\gittest"),new File("D:\\goldstine"));

        //从jdk1.7开始提供了一些nio,自己也可以实现一行代码完成复制的技术
        //java原生的api  nio包实现对应的文件复制
        Files.copy(Paths.get("D:\\goldstine\\1.png"),new FileOutputStream("D:\\goldstine\\gittest\\2.png"));

    }
}
