package org.goldstine.bufferIO;

import java.io.*;

/**
 * 通过复制比较使用低级字节流进行复制与使用包装字节流进行复制之间的性能差别
 *
 */
public class CompareDemo {
    public static final String RESOURCE_FILE="D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt";
    public static final String DEST_FILE="D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo01.txt";
//如果文件太小，可能差别不大
    public static void main(String[] args) {
        //记录通过某一种该方式需要的时间
        long startTime=System.currentTimeMillis();
//        copy01();//0.007
//        copy02();//0.001
//        copy03();//0.001
        copy04();//0.001
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000.0);
    }

    //使用低级的字节流按照一个一个的字节的形式复制文件
    public static void copy01(){
        //try-with-resources
        try(
                InputStream fis = new FileInputStream(RESOURCE_FILE);
                OutputStream fos = new FileOutputStream(DEST_FILE);
                ){
            //创建一个变量记录
            int ch;
            while((ch=fis.read())!=-1){
//                System.out.println((char)ch);
                //将读的这一个字节输出到另一个文件中
                fos.write(ch);//write对应三个方法，分别是写一个字节，写字节数组，写字节数组的一部分
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //使用低级字节流按照一个一个字节数组的形式复制文件
    public static void copy02(){
        try(
                InputStream fis = new FileInputStream(RESOURCE_FILE);
                OutputStream fos = new FileOutputStream(DEST_FILE);
                ){
            //通过字节数组进行复制
            //创建一个字节数组
            byte[] buffer=new byte[1024];
            //创建一个变量
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);//将字节数组的一部分输出
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //使用高级的缓冲个字节流按照一个一个字节的形式复制文件
    public static void copy03(){
        //通过字节缓冲流进行复制
        try(
                //创建低级流
                InputStream fis = new FileInputStream(RESOURCE_FILE);
                OutputStream fos = new FileOutputStream(DEST_FILE);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                ){

            //一个字节一个字节复制
            int ch;
            while((ch=bfis.read())!=-1){
                bfos.write(ch);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //使用高级的缓冲字节流按照字节数组的形式复制文件
    public static void copy04(){
        //通过缓冲字节数组复制
        try(
                InputStream fis = new FileInputStream(RESOURCE_FILE);
                OutputStream fos = new FileOutputStream(DEST_FILE);
                //缓冲流包装
                BufferedInputStream bfis = new BufferedInputStream(fis);
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                ){

            //创建字节数组复制
            byte[] buffer=new byte[1024];
            //创建变量记录
            int len;
            while((len=bfis.read(buffer))!=-1){
                bfos.write(buffer,0,len);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
