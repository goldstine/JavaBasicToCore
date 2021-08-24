package org.goldstine.filedemo;

import java.io.File;

/**
 * File类的概述和API
 *      File类：代表操作系统的文件对象
 *      File类：用来操作操作系统的文件对象的，删除文件，获取文件信息，创建文件（文件夹）
 *      广义来说操作系统认为文件包含（文件和文件夹）
 *          创建一个文件对象：java.io.File
 *              public File(String path)
 *              public File(String parent,String child);根据父路径和文件名称     在递归文件复制的时候有用
 *              public File(File parent,String child);
 *
 *
 */
public class FileDemo01 {
    public static void main(String[] args) {
        //创建文件对象，使用绝对路径
        /**
         * 文件分割符
         * (1)使用正斜杠
         * （2）使用反斜杠
         * （3）使用分隔符api
         */
//        File file=new File("C:\\Users\\15797\\Desktop\\0.png");
//        File file1=new File("C:/Users/15797/Desktop/0.png");
        //通过分隔符api File.separator
        File file2=new File("C:"+File.separator+"Users"+File.separator+"15797"+File.separator+"Desktop"+File.separator+"0.png");
        System.out.println(file2.length());//获取文件的大小，字节大小

        //创建文件对象，使用相对路径
        File file = new File("filedemo.txt");
//        D:\Goldstine_workspace\JavaDevelopment\SpringBoot\JavaCore\FileIO\src\main\java\org\goldstine\filedemo\FileDemo01.java
        System.out.println(file.length());

        //创建文件对象，代表文件夹
        File file1 = new File("C:/Users/15797/Desktop");
        System.out.println(file1.length());//这里获取的对应的文件夹的大小，并不是文件夹包含的所有文件的字节数
        System.out.println(file1.exists());

    }
}
