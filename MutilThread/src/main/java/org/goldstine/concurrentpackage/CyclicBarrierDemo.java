package org.goldstine.concurrentpackage;

import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障
 * CyclicBarrier
 * 作用：某个线程任务必须等待其他线程执行完毕之后，才能最终触发自己执行
 *
 * 例如：召集5名员工开会，等5名员工都到了，会议开始
 * 创建5个员工线程，1个开会任务，几乎同时启动
 * 使用CyclicBarrier保证5名员工线程全部执行后，在执行开会线程
 *
 * 构造器：
 *  public CyclicBarrier(int parties,Runnable barrierAction)
 *  用于在线程到达屏障5时，优先执行barrierAction,方便处理更复杂的业务场景
 *  方法
 *  public int await()
 *  //每个线程调用await()告诉CyclicBarrier已经到达了屏障，然后当前线程被阻塞
 *
 *
 *  循环屏障可以实现达到一组屏障就触发一个任务执行
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //创建一个任务循环屏障对象
        CyclicBarrier c = new CyclicBarrier(5,new Meeting());
        for (int i = 1; i <= 10; i++) {
             new EmployeeThread("员工"+i,c).start();

        }
        //每达到一组屏障，就触发一次动作new barrierAction
/**
 * 员工1正在进入会议室...
 * 员工6正在进入会议室...
 * 员工2正在进入会议室...
 * 员工5正在进入会议室...
 * 员工9正在进入会议室...
 * 员工3正在进入会议室...
 * 员工9开始组织会议...
 * 员工10正在进入会议室...
 * 员工8正在进入会议室...
 * 员工7正在进入会议室...
 * 员工4正在进入会议室...
 * 员工4开始组织会议...
 */
    }
}

class Meeting extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始组织会议...");
    }
}

class EmployeeThread extends Thread{
    //接收循环屏障对象
    private CyclicBarrier c;
    public EmployeeThread(String name,CyclicBarrier c){
        super(name);
        this.c=c;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "正在进入会议室...");
            c.await();//每个线程调用await()方法告诉CyclicBarrier我已经到达了屏障，当前线程被回收，，
            // 这里是回收，相当于回收到线程池
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
