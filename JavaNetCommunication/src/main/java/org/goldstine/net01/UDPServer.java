package org.goldstine.net01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP协议相关的两个类：发送数据包的大小为64KB
 *      DatagramPacket:
 *            数据包对象
 *            作用：用来封装要发送或要接收的数据，比如集装箱
 *       构造器：
 *          发送端：
 *          DatagramPacket(byte[] buf,int length,InetAddress address,int port);
 *              创建发送端数据包对象
 *              buf:要发送的内容，字节数组
 *              length：要发送内容的长度，单位是字节
 *              address:接收端的IP地址对象
 *              port:接收端的端口号
 *          接收端：
 *          DatagramPacket(byte[] buf,int length);   //由于UDP是不可靠的协议，所以不需要知道发送端的ip和端口号
 *              创建接收端的数据包对象
 *              buf:用来存储接收到的内容
 *              length:接收端接收的字节数
 *
 *       DatagramPacket常用方法：
 *       int getLength()获得实际接受的内容长度
 *
 *
 *
 *      DatagramSocket:
 *          发送对象
 *          作用：用来发送或接收数据包，比如码头
 *
 *          构造方法：
 *          DatagramSocket():创建发送端的socket对象，系统会随机分配一个端口号
 *          DatagramSocket(int port)创建接收端的Socket对象并指定端口号
 *
 *          DatagramSocket类成员方法：
 *          void send(DatagramPacket dp)发送数据包
 *          void receive(DatagramPacket p)接收数据包
 *
 */
public class UDPServer {

    /**
     * 服务器端的编写：
     * （1）首先创建接受的链接DatagramSocket(port),指定端口连接
     * （2）创建对应的桶进行接收，并设置对应的桶的大小new byte[],设置桶实际打算接受的数据量大小
     * （3）创建对应的集装箱【DatagramPacket(buffer,length)】
     * (4)通过集装箱进行接收  socket.receive(packet)
     *
     */

    public static void main(String[] args) throws IOException {
        //接收
        byte[] buffer=new byte[1024*64];
        //创建DatagramSocket用于接收数据
        DatagramSocket socket = new DatagramSocket(8080);//服务端的Socket端口与客户端的packet端口相同
        //创建对应的DatagramPacket用于接收数据
//        int length=3;//表示理论最大接收数据长度
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        int len=packet.getLength();
        String s = new String(buffer,0,len);
        System.out.println(s);

        //将接受的数据输出
//        for (int i = 0; i < buffer.length; i++) {
//            System.out.println((char)buffer[i]);
//        }
        //输出实际接受数据的长度
        System.out.println(packet.getLength());

        //服务端还可以获取发来信息的客户端ip和端口
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        System.out.println("对方"+ip+":"+port);//192.168.56.1:57025


        socket.close();
    }
}
