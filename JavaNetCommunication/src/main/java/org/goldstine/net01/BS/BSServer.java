package org.goldstine.net01.BS;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BS架构：
 *      客户端：浏览器（无需开发）
 *      服务端：自己开发
 *      在浏览器中请求本程序，响应一个网页文字给浏览器显示
 *
 */
public class BSServer {
    public static void main(String[] args) throws IOException {
        //注册端口
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            Socket accept = serverSocket.accept();

            //交给一个独立的线程进行处理
            new ServerReaderThread(accept).start();

        }

    }
}
class ServerReaderThread extends Thread{
    private Socket accept;
    public ServerReaderThread(Socket accept) {
        this.accept=accept;
    }

    @Override
    public void run() {
        //响应消息给浏览器显示
        //浏览器是基于http通信的，也就是相应的时候也必须按照http修仪的数据格式进行显示响应
        //有对应的请求头信息和响应头信息

        //直接通过打印流进行响应
        try {
            PrintStream ps = new PrintStream(accept.getOutputStream());
            ps.println("HTTP/1.1 200 OK");//响应头
            ps.println("Content-Type:text/html;charset=UTF-8");//响应数据的类型，网页或者文本信息
            //必须换一行
//            ps.println("\r\n");
            ps.println();

            //以下开始响应数据
            ps.println("<span style='color:green;font-size:60px;'>goldstine</span>");
            Thread.sleep(3000);
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
