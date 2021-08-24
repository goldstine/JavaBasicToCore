package org.goldstine.filedemo;

import java.io.File;

/**
 * File类的判断功能的方法
 *      public boolean exists():此File表示的文件或目录是否实际存在
 *      public boolean isDirectory();此File表示的是否为目录
 *      public boolean isFile();此File表示的是否为文件
 *
 */
public class FileAssertDemo {
    public static void main(String[] args) {
        File file1=new File("C:/Users/15797/Desktop/0.png");
        //判断文件路径是否存在
        System.out.println(file1.exists());
        //判断文件对象是否为文件
        System.out.println(file1.isFile());
        //判断文件对象是否为目录
        System.out.println(file1.isDirectory());

        //当文件对象为目录时
        File file = new File("C:/Users/15797/Desktop");
        //判断文件对象目录是否存在
        System.out.println(file.exists());
        //判断文件对象是否为文件
        System.out.println(file.isFile());
        //判断文件对象是否为目录
        System.out.println(file.isDirectory());
    }
}
