package org.goldstine.net01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 改成发送一条消息接受一条消息
 *
 * 将服务端创建多个线程与多个客户端进行连接通信
 */
public class TCPServer01 {
    public static void main(String[] args) throws IOException {
        Socket accept = new ServerSocket(8080).accept();

        //通过accept获得对应的输入流，然后包装成缓冲字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));

        //怎么输入，就怎么接受
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

    }
}
