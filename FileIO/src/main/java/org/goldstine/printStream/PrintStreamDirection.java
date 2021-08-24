package org.goldstine.printStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 打印流改变输出的流向，重定向
 *
 * System:
 *      public static void setOut(PrintStream out):让系统的输出流向打印流
 */
public class PrintStreamDirection {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = new PrintStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\log.txt");

        //让系统的输出流向打印流
        System.setOut(ps);

        System.out.println("liulei");
        System.out.println("goldstine");//系统输出流向打印流
        System.out.println("我是中国人");


    }

}
