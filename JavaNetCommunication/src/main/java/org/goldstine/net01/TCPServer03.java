package org.goldstine.net01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池改进
 *
 * 线程越多，并发越高，系统瘫痪越快
 *
 *通过线程池改进，优势：不会引起系统的死机，可以控制并发线程的数量
 * 劣势：同时可以并发的线程将受到限制
 *
 * 最好通过在自定义的方式创建线程池，new ThreadPoolExector(核心线程数，最大线程数，...，任务队列)的方式创建线程池
 *
 * 任务队列创建的线程池，当其中一个线程下线的时候，不会在服务端发生异常
 *
 *
 */
public class TCPServer03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        //创建线程池
        //创建ExecutorService接口对象
        ExecutorService es = Executors.newFixedThreadPool(3);


        while(true){
            Socket accept = serverSocket.accept();

            if(accept!=null){
                //创建对应的线程处理
                //创建一个任务，将任务提交到线程池
                Runnable task = new MyRunnable(accept);
                es.submit(task);
            }

        }

    }
}

class MyRunnable implements Runnable{
    private Socket accept;
    public MyRunnable(Socket accept) {
        this.accept=accept;
    }

    //通过带参构造函数获得对应的
    @Override
    public void run() {
        //通过socket获得对应的输入流
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));

            //通过缓冲字符流循环都取数据
            String line;
            while((line=br.readLine())!=null){
                System.out.println("当前线程为："+Thread.currentThread().getName()+"远程客户端的ip"+ accept.getRemoteSocketAddress()+line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}