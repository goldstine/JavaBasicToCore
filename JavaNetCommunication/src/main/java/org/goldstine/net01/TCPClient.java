package org.goldstine.net01;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *（1）客户端要求请求服务端的socket管道连接
 * （2）从socket通信管道中得到一个字节输出流   OutputStream
 * (3)通过字节输出流给服务端写出数据
 *
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、客户端要请求服务端的socket管道连接
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);
        //2、从socket通信管道中获得一个字节输出流
        OutputStream os = socket.getOutputStream();

        //将低级输出流直接包装成打印流  ，打印流已经底层包装了缓冲流，并且可以打印字节和字符

        PrintStream ps = new PrintStream(os);

        //通过打印流发送数据

        ps.println("我是中国人，银河系");

        ps.flush();//由于是长连接，所以不要关闭流
        System.out.println("客户端发送完毕！！！");
    }
}
