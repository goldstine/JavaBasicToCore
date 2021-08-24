package org.goldstine.bufferIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 字符缓冲输出流：BufferedWriter
 *      作用：字符缓冲流可以把字符输出流包装成一个高级的缓冲字符输出流
 *  *      可以提高字符输出流读数据的性能
 *  *
 *  *      构造器：public BufferedReader(Writer writer);
 *  *      原理：缓冲字符输出流默认会有一个8K的字符缓冲池，可以写字符的性能
 *  *
 *  *      还多了一个换行的功能
 *  *     public void newLine();新建一行
 *
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("D:\\Goldstine_workspace\\JavaDevelopment\\SpringBoot\\JavaCore\\FileIO\\src\\main\\java\\org\\goldstine\\filedemo02.txt",true);

        //如果要创建一个追加的缓冲字符输出流，还是在原来的地方加上true

        //将低级的字符输出流包装成一个缓冲字符输出流
        BufferedWriter writer1 = new BufferedWriter(writer);


        //可以写一个字符，写一个字符串，写一个字符串部分，写一个字符数组，写一个字符数组一部分
        writer1.write('a');
        writer1.write(97);

        writer1.write("\r\n");

        writer1.write("我爱中国");

        //多了一个新建一行的方法
        writer1.newLine();

        writer1.write("江西省".toCharArray());

        writer1.close();
    }
}

/**
 * List集合提供indexOf()来根据对应的值获取在List集合中的索引值
 *
 * //创建一个List
 * List<Character> sizes=new ArrayList<>();
 * Collections.addAll(sizes,'零','一','二','三'....)
 *
 */
