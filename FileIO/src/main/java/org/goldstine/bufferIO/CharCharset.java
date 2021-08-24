package org.goldstine.bufferIO;

import java.io.InputStreamReader;

/**
 * 字符流不同编码读取乱码的问题
 *      代码文件和文本文件编码不同导致的乱码问题
 *      字符流读取：
 *      代码编码            文件编码            中文情况
 *      UTF-8                  UTF-8            不乱码
 *      GBK                    GBK              不乱码
 *      UTF-8                   GBK             乱码
 *
 *
 *      InputStreamReader   extends Reader
 */
public class CharCharset {
    public static void main(String[] args) {

    }
}
