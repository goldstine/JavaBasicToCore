package org.goldstine.threadcommunication;

/**
 * 存钱线程类
 */
public class SaveThread extends Thread{
    //定义一个存钱账户
    private Account acc;

    public SaveThread(Account acc,String name){
        super(name);//为当前线程对象取名字
        this.acc=acc;
    }

    @Override
    public void run() {
        //定义三个存钱爸爸反复存钱
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acc.saveMoney(100000);
        }
    }
}
