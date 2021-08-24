package org.goldstine.filedemo;

import java.io.File;

/**
 * File类的获取功能的API
 * public String getAbsolutePath():返回此File的绝对路径名字符串
 * public String getPath();获取创建文件对象的时候用的路径
 * public String getName();返回由此File表示的文件或目录的名称
 * public long length();返回由此File表示的文件的长度
 *
 */
public class FileApi {
    public static void main(String[] args) {
        File file1=new File("C:/Users/15797/Desktop/0.png");
        //获取绝对路径
        System.out.println(file1.getAbsolutePath());
        //获取文件定义时使用的路径
        System.out.println(file1.getPath());
        //获取文件的名称，带后缀
        System.out.println(file1.getName());
        //获取文件长度
        System.out.println(file1.length());


        //通过相对路径创建文件对象
        File file = new File("../../FileIO/src/filedemo.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.length());
    }

}
