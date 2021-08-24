package org.goldstine.printStream;

import java.io.*;

/**
 * 打印流PrintStream/PrintWriter
 * 打印流的作用：
 *  （1）可以方便，快速地写数据出去
 *  （2）可以实现打印啥出去，就是啥出去
 *
 *  打印流的构造器
 *      public PrintStream(OutpurStream os);
 *      public PrintStream(String filePath);
 *
 *   小结：
 *      打印流其实是比缓冲流更高级的流，打印流底层包装了缓冲流
 *
 *      打印流还可以打印字节数组
 *      PrintStream不但可以打印数据，还可以写字节数据出去
 *      PrintWriter不但可以打印数据，还可以写字符数据出去
 *
 *      注意：PrintWriter打印字符数据
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        //打印流printStream
//        OutputStream fos = new FileOutputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo04.txt");
//
//        //打印流
//        PrintStream ps = new PrintStream(fos);//将输出字节流OutputStream/FileOutputStream流输出到对应的打印流
//
//        //通过打印流进行操作
//        ps.println(97);//可以打印所有的基本数据类型
//        ps.println(110);
//        ps.println("我在黑马快乐的调皮》》》");
//        ps.println(99.2);
//        ps.println('磊');


        //(二)打印流可以直接通过构造器直接操作文件
//        PrintStream ps = new PrintStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo04.txt");
//        //创建追加的方式打印?  默认的方式是直接采用覆盖的方式进行打印
//        //如果要采用追加打印的方式，还是要通过输出字节流的方式进行构造打印流
//        //new PrintStream(new FileOutputStream(String filePath,boolean append))
//        ps.println("asasas");
//
//        ps.write("我爱中国".getBytes());


        //通过PrintWriter打印字符数据
        PrintWriter pw = new PrintWriter("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo04.txt");
        pw.write("我是中国人".toCharArray());

        pw.close();
    }
}
