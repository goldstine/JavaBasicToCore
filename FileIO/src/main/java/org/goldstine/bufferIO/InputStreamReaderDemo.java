package org.goldstine.bufferIO;

import java.io.*;

/**
 * InputStreamReader:  属于字符流，解决不同编码文件之间的字符流读取问题，可以解决乱码问题
 *本质上，是首先通过字节流读取，然后转换为字符流
 *
 * 构造器：
 *      public InputStreamReader(InputStream is);可以按照当前代码默认编码转换成字符流  【基本不用】
 *      public InputStreamReader(InputStream is,String charset);可以指定编码
 *
 * 小结：
 *      字符输入流可以把字节输入流按照默认编码转换成字符输入流
 *      字符输入转换流也可以指定编码把字节输入流转换成字符输入流
 *
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        //提取GBK文件原始字节流
        InputStream fis = new FileInputStream("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo.txt");
        //把原始字节输入流转换流，转换成字符输入流InputStreamReader
        Reader isr = new InputStreamReader(fis,"UTF-8");
//        Reader isr = new InputStreamReader(fis,"GBK");//因为继承自Reader所以直接写成Reader接收引用
        //转换之后，属于Reader,所以还可以包装成缓冲字符流
        BufferedReader bufferedReader = new BufferedReader(isr);

        String line;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
}
