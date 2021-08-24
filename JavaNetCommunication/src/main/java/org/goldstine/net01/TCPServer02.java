package org.goldstine.net01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建一个多线程版的服务端
 * 对应的客户端为：TCPClient01
 */
public class TCPServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true) {//需要反复循环进行接收
            Socket accept = serverSocket.accept();
            if (accept != null) {
                //创建一个线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //对应的socket获得输入流
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));

                            //通过缓冲字符输入流
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println("当前线程为"+Thread.currentThread().getName()+line);
                                //打印远程客户端的ip
                                System.out.println(accept.getRemoteSocketAddress());
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        }
    }
}
