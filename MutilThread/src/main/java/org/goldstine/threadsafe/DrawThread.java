package org.goldstine.threadsafe;

//创建一个线程类，创建取钱线程对象
public class DrawThread extends Thread{

    //定义一个成员变量接收账户
    private Account acc;
//    private String name;//对应的父类有对应的name属性，通过继承过来，所以直接super(name)

    //定义一个有参构造器接收账户
    public DrawThread(Account acc,String name){
        super(name);
        this.acc=acc;

    }

    @Override
    public void run() {
        //两个用户分别取款10000
        acc.drawMoney(100000);
    }
}
