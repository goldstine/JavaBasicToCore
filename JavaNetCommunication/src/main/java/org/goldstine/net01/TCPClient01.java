package org.goldstine.net01;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 */
public class TCPClient01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
        //通过socket获得对应的输出流
        PrintStream ps = new PrintStream(socket.getOutputStream());

//        ps.println("我是银河系中的一粒尘埃");
        Scanner scanner = new Scanner(System.in);

        while(true){
            //客户端循环发送
            System.out.println("请说：");
            ps.println(scanner.nextLine());
            ps.flush();
        }
        //通过这种方式一次只能由一个客户端与服务端进行通信
        /**
         * 解决的方式是通过，服务端为每一个客户端建立一个线程与之通信
         * 优化的方式是通过将所有的线程回收利用，所以创建对应的线程池与之通信
         */

    }
}
