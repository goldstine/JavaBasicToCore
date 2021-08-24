package org.goldstine.filedemo;

import java.io.File;
import java.io.IOException;

/**
 * File类的创建和删除方法
 *      public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件（几乎不用，）
 *      public boolean delete():删除由此File表示的文件或目录（只能删除空目录，类似于linux只能递归删除）
 *      public boolean mkdir():创建由此File表示的目录（只能创建一级目录）
 *      public boolean mkdirs():创建多级目录(建议使用）
 */
public class FileCreateAndDelete {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\goldstine\\goldstine.txt");
        //创建新文件，创建成功返回true
        boolean newFile = file.createNewFile();//如果已经存在，则不会创建，

        System.out.println(newFile);

        //删除文件或文件夹
        boolean delete = file.delete();
        System.out.println(delete);
        //删除空文件夹
        File file1 = new File("D:\\goldstine\\asas");
        System.out.println(file1.delete());
        //创建文件夹
        boolean mkdir = file1.mkdir();
        System.out.println(mkdir);

        File file2 = new File("D:\\goldstine\\asas\\bbb\\ccc");
        System.out.println(file2.mkdirs());
    }
}
