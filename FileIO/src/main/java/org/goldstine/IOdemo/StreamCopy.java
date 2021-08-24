package org.goldstine.IOdemo;

import java.io.*;

/**
 * 字节流复制的思想：
 *      字节流适合做一切文件的复制
 *      复制是把源文件的全部字节一字不漏地转移到目标文件，只要文件前后的格式一样，绝对不会有问题
 *
 *
 *      jdk1.7开始之后释放资源的新方式
 *      try-with-resources:
 *          try（
 *              //这里只能放置资源对象，用完自动调用close()关闭
 *          ）{
 *
 *          }catch(Exception e){
 *              e.printStackTrace();
 *          }
 *      什么是资源？
 *          资源类一定是实现了Closeable接口，实现这个接口的类就是资源
 *          有close()  try-with-resources会自动调用它的close()关闭资源
 *
 */
public class StreamCopy {
    public static void main(String[] args) {
//        InputStream fis=null;
//        OutputStream fos=null;
        //创建一个字节输入流管道与源文件接通
        try(
                /**
                 * 这里只能定义资源对象
                 * 相当于是常量，只能定义一次
                 */
                InputStream  fis = new FileInputStream("C:\\Users\\15797\\Desktop\\0.png");

        //创建一个字节输出流与目标文件接通
                OutputStream fos = new FileOutputStream("D:\\goldstine\\1.jpg");
                ) {

            //创建一个字节数组作为桶，大小一般为1024KB
            byte[] buffer=new byte[1024];

            //从字节输入流管道中读取数据，写出到字节输出流管道即可
            //定义一个变量存储每次桶读取的字节数
            int len;
            while((len=fis.read(buffer))!=-1){
                //读取多少就倒出多少
                fos.write(buffer,0,len);

            }
            //完成
            System.out.println("复制完成");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if(fis!=null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(fos!=null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
}
