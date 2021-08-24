package org.goldstine.IOdemo;

import java.io.*;

/**
 * IO流读写：
 *  IO输入输出流
 *  引入：File类只能操作文件对象本身，不能读写文件对象的内容
 *  读写文件的数据内容，应该使用IO流
 *
 *  IO流是一个水流模型，IO理解成水管，把数据理解成水流
 *  IO流的分类：
 *      按照流的方向分为：输入流，输出流
 *（1）输出流：以内存为基准，把内存中的数据写出到磁盘文件或者网络介质中去的流称为输出流
 * 输出流的作用：写数据到文件，或者写数据发送给别人
 *
 * （2）输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据读入到内存中去的流称为输入流
 * 输入流的作用：读取数据到内存
 *
 * 按照流的内容分为：
 *      字节流和字符流
 *     （1）流中的数据的最小单位是一个一个的字节，这个流就是字节流【音视频文件】
 *     （2）字符流，流中的数据的最小单位是一个一个的字符，这个流就是字符流 【文本文件】
 *
 *     所以流可以分为四大类：
 *     （1）字节输入流，以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字节的形式读入到内存中去的流称为输入字节流
 *     （2）字节输出流：以内存问基准，把内存中的数据以一个一个的字节写出到磁盘文件或者网络介质中去的流称为字节输出流
 *     （3）字符输入流，以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字符的形式读入到内存中去的流称为输入字符
 *     （4）字符输出流，以内存问基准，把内存中的数据以一个一个的字符写出到磁盘文件或者网络介质中去的流称为字符输出流
 *
 *     IO流体系：
 *          字节输入流：InputStream【抽象类】   FileInputStream  【实现类】
 *          字节输出流：outputStream【抽象类】   FileOutputStream【实现类】
 *
 *          字符流：
 *              字符输入流：
 *              Reader  [抽象类]
 *              FileReader【实现类】
 *
 *              字符输出流：Writer【抽象类】
 *              FilrWriter【实现类】
 *
 * FileInputStream:
 *      构造器：
 *      public FileInputStream(File path);创建一个字节输入流管道与源文件对象接通
 *      public FileInputStream(String pathName);创建一个字节输入流管道与文件路径对接  【直接使用简化写法】
 *
 *      方法：
 *      public int read();每次读取一个字节返回，读取完毕之后会返回-1
 *      public int read(byte[] buffer);从字节输入流中读取字节到字节数组中去，返回读取的字节数量，没有字节可读时返回-1
 *
 *
 * 小结：一个一个字节读取引文和数字没有问题
 * 但是一旦读取中文输出无法避免乱码，因为会截断中文的字节
 * 一个一个自己的读取数据，性能也较差，所以禁止使用此方案
 * 
 *
 */
public class IODemo {
    public static void main(String[] args) throws IOException {
        //创建文件对象定位filedemo.txt
//        File file = new File("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt");
//        //创建一个字节输入流管道与源文件接通
//        FileInputStream ins = new FileInputStream(file);
//        //读取一个字节的编号返回，读取完毕返回-1
//        int code1=ins.read();
//        System.out.println((char)code1);
//
//        int ch=0;
//        while((ch=ins.read())!=-1){
//            System.out.println((char)ch);
//        }

        //通过读取一个字节数组

        //（1）首先创建一个字节输入流
       InputStream ins = new FileInputStream("D:\\\\Goldstine_workspace\\\\JavaDevelopment\\\\SpringBoot\\\\JavaCore\\\\FileIO\\\\src\\\\main\\\\java\\\\org\\\\goldstine\\\\filedemo.txt");
        //底层还是通过new File()创建一个文件对象，然后通过文件对象创建输入流

        //定义一个桶，定义一个字节数组读取数据
        byte[] buffer=new byte[3];
        //从ins管道中读取字节装入到字节数组中去，返回读取自己的数量

        int len=ins.read(buffer);
        System.out.println("读取了字节数："+len);

        String s = new String(buffer);//字符串String有对应的构造方法，能够将字节数组转成对应的字符串
        System.out.println(s);

        //读第二滴水
        int len1=ins.read(buffer);
        System.out.println("读取了字节数："+len1);

        String ss = new String(buffer);//字符串String有对应的构造方法，能够将字节数组转成对应的字符串
        System.out.println(ss);

        //读第三滴水
        int len2=ins.read(buffer);
        System.out.println("读取了字节数："+len2);

        String s2 = new String(buffer);//字符串String有对应的构造方法，能够将字节数组转成对应的字符串
        System.out.println(s2);

        //正常情况，读取了多少字符，就应该倒出多少字符
        //String同样提供构造器，将制定长度的字节数组进行转换成字符串
        String s1 = new String(buffer, 0, len2);
        System.out.println(s1);

        //继续读，没有对应的数据，所以返回-1
        int len3=ins.read(buffer);
        System.out.println("读取了字节数："+len3);

//        String s3 = new String(buffer,0,len3);//字符串String有对应的构造方法，能够将字节数组转成对应的字符串
//        System.out.println(s3);



    }
}
