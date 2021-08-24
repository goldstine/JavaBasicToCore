package org.goldstine.threadsafe;

/**
 * 线程安全问题
 *      多个线程操作同一共享资源的时候可能会出现线程安全问题
 *
 */
public class ThreadSafe {

    public static void main(String[] args) {
        //创建一个共享资源账户对象
        Account acc = new Account("ICBC-110", 100000);

        //创建两个线程分别模拟两个用户去存取款
        Thread t1 = new DrawThread(acc,"xiaoming");
        t1.start();
        Thread t2=new DrawThread(acc,"xiaohong");
        t2.start();
    }
}
