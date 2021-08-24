package org.goldstine.IOdemo;

import java.io.*;

/**
 * 字节输出流
 *      FileOutputStream文件字节输出流
 *      作用：以内存问基准，把内存中的数据，按照字节的形式写出到磁盘文件中去
 *          简单来说，就是把内存数据按照字节写出到磁盘文件中去
 *      构造器：
 *      public FileOutputStream(File file);创建一个字节输出流管道通向目标文件对象
 *      public FileOutputStream(String file):创建一个字节输出流管道通向目标文件路径
 *      public FileOutputStream(File file,boolean append);创建一个追加数据的字节输出流
 *      public FileOutputStream(String file,boolean append);创建一个追加数据的字节输出流
 *
 * 每次创建一个管道，就会将之前写的所有数据清空，然后使用新创建的管道写数据
 *
 *      方法
 *      public void write(int a);写一个字节出去,通过整形的int  的ascii进行接收
 *      public void write(byte[] buffer);写一个字节数组出去
 *      public void write(byte[] buffer,int pos,int len);写一个字节数组的一部分出去
 *                          字节数组     起始字节索引位置    写多少个字节数出去
 *        
 *小结：
 * 字节输出流可以写字节数据到文件中去
 * 写一个字节，写一个字节数组，写一个字节数组的一部分出去
 *   管道用完需要关闭，数据要生效需要刷新，关闭包含刷新，刷新后流可以继续使用，关闭之后流无法继续使用
 *  assasaaaa
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //创建一个文件对象定位i目标文件 ,写数据到文件，文件会自动创建
        File file = new File("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt");
        //创建一个字节输出流管道与目标文件对象接通
        OutputStream fos = new FileOutputStream(file);
        //写数据出去
        //写一个字节出去（写一滴水出去）
        fos.write(97);//字节a
        fos.write('b');//字节b
//        fos.write('磊');//每次只能够写一个字节

        //输出换行，建议使用\r\n，加上\r是因为有一些系统的换行符可能不是\n
        fos.write("\r\n".getBytes());

        //写一个字节数组出去
        byte[] bytes=new byte[]{98,99,100,101,102,103};
        fos.write(bytes);
        fos.write("\r\n".getBytes());
        //将字符串转换为字节数组
        byte[] bytes1 = "Java是最优美的语言,我爱Java!\r\n".getBytes();
//        byte[] bytes1 = "Java是最优美的语言,我爱Java!".getBytes("GBK");
        System.out.println(bytes1.length);//37  ,!分别占一个字节
        //默认是以UTF-8编码的方式提取字节
        fos.write(bytes1);
        fos.write("\r\n".getBytes());
        //写一个字节数组的一部分出去
        byte[] bytes2="java是最优美的语言".getBytes();
        fos.write(bytes2,0,10);

//        fos.flush();//立即刷新数据到文件中去，刷新后管道可以继续使用
        fos.close();//关闭资源管道，关闭包含了刷新，关闭后管道不能使用了


        OutputStream fos1 = new FileOutputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt",true);
        fos1.write('a');

        fos1.close();
    }
}
