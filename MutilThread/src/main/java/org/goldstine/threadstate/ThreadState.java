package org.goldstine.threadstate;

public class ThreadState {
    /**
     * 线程状态： 从线程通信衍生出的问题
     *      当线程被创建并启动以后，他并不是一启动就进入执行状态，也不是一直处于执行状态
     *      在api中java.lang.Thread.State这个枚举类中给出了六种线程状态
     *
     *      （1）new新建，线程刚被创建出来，还未调用start()
     *      （2）可运行态（Runnable）;包含两个状态：就绪态和运行态  分别对应获取到cpu和没有获取到cpu
     *      （3）终止态：任务执行完毕，线程死亡
     *      (4)阻塞态，线程进入阻塞态，锁到了其他线程手中进行执行，阻塞态的线程等待重新获取到锁执行
     *      (5)无限等待：wait()进入之后必须等待另一个线程唤醒，如果没有其他线程唤醒，同样也会从无限等待进入阻塞态
     *      （6）计时等待：sleep(long time);sleep等待没有释放锁，到时之后立即继续执行
     *                  wait(long time);释放锁等待，如果到时之后没有获取到锁，从计时等待转入阻塞态
     */
    public static void main(String[] args) {

    }
}
