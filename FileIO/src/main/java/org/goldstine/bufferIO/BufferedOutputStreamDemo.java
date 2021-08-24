package org.goldstine.bufferIO;

import java.io.*;

/**
 * 缓冲字节输出流
 *      作用，可以将低级的字节输出流包装成一个高级的缓冲字节输出流，从而提高些数据的性能
 *      构造器：
 *      public BufferedOutputStream(OuputStream os)
 *      缓冲字节输出流自带了一个8KB缓冲池，数据直接写入到缓冲罐池中去，性能极高
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        OutputStream fos = new FileOutputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo02.txt");

        //通过缓冲流进行包装
        BufferedOutputStream bfos = new BufferedOutputStream(fos);

        bfos.write('a');

        bfos.write(100);
        bfos.write('b');

        bfos.write("我爱中国".getBytes());

        bfos.close();

    }
}
