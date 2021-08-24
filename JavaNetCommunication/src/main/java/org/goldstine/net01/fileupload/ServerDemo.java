package org.goldstine.net01.fileupload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 实现客户端上传图片给服务端保存起来
 *
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //注册端口
        ServerSocket serverSocket = new ServerSocket(8080);
        //创建线程池
        ExecutorService es = Executors.newFixedThreadPool(3);

        while(true){
            Socket accept = serverSocket.accept();
            if(accept!=null){
                //创建一个任务，提交到线程池
                Runnable r = new MyRunnable(accept);
                es.submit(r);
            }
        }

    }
}
//创建对应的任务
class MyRunnable implements Runnable{
    private Socket accept;
    public MyRunnable(Socket accept) {
        this.accept=accept;
    }

    @Override
    public void run() {
        //通过socket获得输入流
        InputStream is = null;
        try {
            is = accept.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //将输入字节流包装成缓冲输入字节流
        BufferedInputStream bis = new BufferedInputStream(is);
        //bis作为通信管道，不要关闭
        //对应的服务器端的流最好不要关闭，所以不要放到try-with-resources代码块中自动关闭
        try(
                //获得对应的输出流将数据从服务器内存保存到磁盘文件中
                OutputStream fos = new FileOutputStream(new File("D:\\goldstine\\goldstine.png"));
                //正常情况下，文件的后缀名需要客户端传输到服务器端，才能知道存存为一个什么样的文件
                //服务器端的文件名一般通过UUID.randomUUIO.toString()+".png"

                //将输出流包装成缓冲输出字节流
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ){

            byte[] buffer=new byte[1024];
            int len;
            while((len=bis.read(buffer))!=-1){     //服务端的通信流读取到最后一个数据，不会返回-1，而是会一直在这里等待
                //所以客户端发送完之后，发送socket.shutdownOutput();
                //将读的数据输出到磁盘文件中
                bos.write(buffer,0,len);
                bos.flush();
//                System.out.println("远程客户端"+accept.getRemoteSocketAddress()+"传输成功");
            }


            //服务端响应客户端的传输结果
            //通过一个字符输出流
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()));

            pw.write("传输成功！！！");
            pw.close();

            Thread.sleep(10000);

        }catch(Exception e){
            e.printStackTrace();
        }



    }
}
