package org.goldstine.volatilevis;

/**
 * 原子性：所谓的原子性指在一次操作或多次操作中，要么所有的操作全部都得到了执行，并且不会受到任何因素的干扰而中断，要么所有操作都不执行
 *
 * 面试必问volatile关键字
 *      并发编程下，多线程访问变量的不可见性问题
 *      变量的不可见性：
 *          多个线程访问共享变量，会出现一个线程修改变量的值之后，其他线程看不到最新值的情况
 *
 *  小结：并发编程下，多个线程修改变量，会出现线程修改之后的不可见性
 *
 *
 *  不可见性的原因：
 *          不可见行内存语义：JMM：java为并发编程单独设计的一种内存模型规范，是java虚拟机规范中所定义的一种内存模型，java内存模型是标准化的，屏蔽了底层不同计算机之间的区别
 *
 *          每个线程都有自己的工作内存，线程都是从主内存拷贝共享变量的副本到工作内存进行操作
 *          每个线程都是在自己的工作内存中操作共享变量的。
 *
 *
 *
 *
 */
public class VolatileDemo01 extends Thread{
    private boolean flag=false;

    //重写线程run()


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程中修改变量
        flag=true;
        System.out.println("flag="+flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

//编写主类
class VisiblityDemo{
    public static void main(String[] args) {
        //创建子线程，修改flag
        VolatileDemo01 t1 = new VolatileDemo01();
        t1.start();

        while(true){
            if(t1.isFlag()){
                System.out.println("主线程进入执行.....");
            }
        }
    }
}