package org.goldstine.net01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 软件基本结构
 * InetAddresss类的使用：
 *      一个该类的对象就代表一个IP地址对象
 *    InetAddress类成员方法
 *      static InetAddress getLocalHost():获得本地主机IP地址对象
 *      static InetAddress getByName(String host):根据IP地址字符串或主机名获得对应的IP地址对象
 *      String getHostName();获得主机名
 *      String getHostAddress();获得IP地址字符串
 *
 */
public class NetDemo01 {
    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());

        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

        InetAddress ip3 = InetAddress.getByName("39.156.66.18");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());

        //判断是否能通：ping
        System.out.println(ip3.isReachable(5000));

        
    }
}
