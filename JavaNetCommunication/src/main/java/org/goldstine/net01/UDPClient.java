package org.goldstine.net01;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    /**
     * 客户端编写：
     * （1）创建字节数组，获得对应的ip地址和端口
     * （2）将字节数组和ip端口，打包成DatagramPacket集装箱对象
     * (3)通过构造函数获得对应的数据传输DatagramSocket
     *
     */
    public static void main(String[] args) throws IOException {
        //创建对应的数据包发送给服务端
        //创建对应的数据用于发送
        InetAddress ip = InetAddress.getLocalHost();
//        byte[] buffer=new byte[]{'a','b','c','d','e'};
        byte[] buffer="我是中国人".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 8080);
        //客户端通过DatagramSocket将数据发送出去
        DatagramSocket socket = new DatagramSocket(6666);

        //发送
        socket.send(packet);
        socket.close();
    }

}
