package org.goldstine.filedemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * File针对目录遍历
 *  public String[] list();获取当前目录下所有的以及文件名称到一个字符串数组中返回
 *  public File[] listFiles():
 *      获取当前目录下所有的一级文件对象到一个文件对象数组中去返回
 */
public class FileIterator {
    public static void main(String[] args) {
//        File file = new File("D:\\Goldstine_workspace");
//        //获取当前目录对象下的全部一级文件名称到一个字符串数组中
//        String[] list = file.list();
//        System.out.println("所有文件名称："+ Arrays.toString(list));
//
//        //通过listFiles()获取所有的文件对象
//        File[] files = file.listFiles();
//        for (File file1 : files) {
//            System.out.println(file1);
//        }
//
//        //获取文件的最后修改时间
//        File file1=new File("C:/Users/15797/Desktop/0.png");
//        //获得最后修改时间的时间毫秒数
//        long time = file1.lastModified();
//
//        //将该时间毫秒数转为特殊字符串形式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        String format = sdf.format(time);
//        System.out.println(format);


        //递归遍历目录
        //猴子吃桃问题    猴子每天吃剩下的桃子的一般多一个桃子

        //问第一天总共有多少个桃子
        /**
         * f[n]表示第n天剩余的桃子
         * f[10]=1
         * f[n]=f[n-1]-f[n-1]/2-1=f[n-1]/2-1 ===>f[n]=2*f[n+1]+2;
         * 求f[1]
         */
//        System.out.println(f(1));
        //通过递归的方式求1+2+。。。+n    1*2*...n
        //递归的方式只能解决规律化递归问题
        //对于非规律化递归问题，啤酒问题和文件遍历问题


        //文件遍历问题   递归实现文件搜索
        //希望去某一个目录下寻找eclipse.exe文件    git-cmd.exe

        /**
         * （1）定义一个方法用于做搜索
         * (2)进入方法中进行业务搜索分析
         */

        searchFiles(new File("D:\\Goldstine_workspace"),"Typora.exe");

    }
    public static int f(int n){
        if(n==10){
            return 1;
        }else{
            return 2*f(n+1)+2;
        }
    }


    public static void searchFiles(File dir,String fileName){
        //1、判断是否存在该路径，是否是文件夹
        if(dir.exists()&&dir.isDirectory()){
            //提取当前目录下的全部以及文件对象
            File[] files = dir.listFiles();
            //判断是否存在一级文件对象，不同的操作系统可能出现返回的文件对象为  null/[]
            if(files!=null && files.length>0){
                //判断一级文件对象
                for (File file : files) {
                    //判断file是文件还是文件夹
                    if(file.isFile()){
                        //判断该文件是否是要找的文件
                        if(file.getName().contains(fileName)){
                            System.out.println(file.getAbsolutePath());
                            //return
                            //可以启动对应的文件
                            Runtime r=Runtime.getRuntime();
                            try {
                                r.exec(file.getAbsolutePath());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }else{
                        //递归访问文件夹
                        searchFiles(file,fileName);
                    }
                }
            }
        }
    }

}
