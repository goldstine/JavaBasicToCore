package org.goldstine.net01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket类构造方法：
 * Socket(String host,int port)
 *  根据ip地址字符串和端口号创建客户端Socket对象
 *  只要执行该方法，就会立即连接指定的服务端程序，如果连接不成功，则会抛出异常
 *  如果连接成功，则表示三次握手通过
 *
 *  Socket类常用方法：
 *      OutputStream  getOutputStream();获得字节输出流对象
 *      InputStream  getInputStream();获得字节输入流对象
 *
 *
 * TCP的通信时可靠通信，需要提前建立连接，所以是基于字节流的数据传输，，要先建立IO流管道
 * 服务端开发流程：
 * （1）注册端口
 * （2）接收客户端的socket管道连接
 *
 * 小结：
 *      （1）客户端用Socket连接服务端
 *      （2）服务端用serverSocket注册端口，接收客户端的Socket连接
 *      （3）通信是很严格的，对方怎么发，你就应该怎么接收，对方发多少你就只能收多少
 *      （4）实现的面向连接的socket端到端的通信管道，一方如果出现异常，另一方也会出现异常
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //服务端也存在一个serversocket
        ServerSocket serverSocket = new ServerSocket(8080);

            //服务端阻塞监听对应的端口号
            Socket accept = serverSocket.accept();//一旦有对应的客户端连接，则会创建一个socket连接

            InputStream is = accept.getInputStream();

            //将输入字节流包装成一个缓冲字符输入流
            //首先将字节输入流转为字符流
            Reader isr = new InputStreamReader(is);
            //将字符流转为缓冲流
            BufferedReader br = new BufferedReader(isr);

            //通过缓冲字符输入流读数据readLine()
            String line;
            if((line=br.readLine())!=null){
                System.out.println(line);
            }



    }
}
