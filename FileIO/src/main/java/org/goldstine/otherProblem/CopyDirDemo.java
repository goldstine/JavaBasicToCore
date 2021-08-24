package org.goldstine.otherProblem;

import java.io.*;

/**
 * 复制文件夹
 *
 *
 */
public class CopyDirDemo {
    public static void main(String[] args) {
        copyDir(new File("D:\\Goldstine_workspace\\Typora\\Typora_install\\Typora"),new File("D:\\goldstine"));
    }

    //通过文件对象参数进行调用
    public static void copyDir(File srcDir, File destDir){
        //首先判断源文件夹是否存在，以及是否是一个文件夹
        if(srcDir.exists()&&srcDir.isDirectory()){
            //创建目标文件夹
            destDir.mkdir();
            //获取所有的文件对象一级
            File[] files = srcDir.listFiles();
            if(files!=null &&files.length>0){//如果该文件对象存在    判断一级文件对象是否存在
                for (File file : files) {//遍历每一个文件对象

                    if(file.isFile()){
                        //将该文件进行复制  //直接通过字节流复制  通过缓冲字节流
                        copy01(file,new File(destDir,file.getName()));

                    }else if(file.isDirectory()){
                        //递归遍历
                        copyDir(file,new File(destDir,file.getName()));
                    }
                }
            }

        }
        System.out.println("复制成功！");
    }

    private static void copy01(File src, File dest) {
        try(
                InputStream fis = new FileInputStream(src);
                OutputStream fos = new FileOutputStream(dest);
                //包装成缓冲流
                BufferedInputStream bfis = new BufferedInputStream(fis);
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                ){

            //通过缓冲流进行复制
//            创建字节数组
                    byte[] buffer=new byte[1024];
                    int len;
                    while((len=bfis.read(buffer))!=-1){
                        bfos.write(buffer,0,len);
                    }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
