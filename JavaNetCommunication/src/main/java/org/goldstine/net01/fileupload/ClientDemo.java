package org.goldstine.net01.fileupload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //将本地的图片传送给服务端的图片保存
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);

        //通过socket获得对应的输出流
        OutputStream os = socket.getOutputStream();

        //传图片，直接使用缓冲字节输出流即可
        BufferedOutputStream bos = new BufferedOutputStream(os);

       try(
               //首先要通过输入流将磁盘上的图片读取出来
               InputStream fis = new FileInputStream("C:\\Users\\15797\\Desktop\\0.png");

               BufferedInputStream bfs = new BufferedInputStream(fis);
               ){

           byte[] buffer=new byte[1024];
           int len;
           while((len=bfs.read(buffer))!=-1){
               //将读取的字节数据通过socket传输给服务端
               bos.write(buffer,0,len);
               bos.flush();
           }

           socket.shutdownOutput();//通知服务端我的数据已经发送完毕，请不要等我了

           System.out.println("客户端传输图片数据完毕了！！！");
           //接收服务端的相应信息
           BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

           //响应消息只需要读取一行
           System.out.println(br.readLine());

       }catch(Exception e){
           e.printStackTrace();
       }


    }
}
