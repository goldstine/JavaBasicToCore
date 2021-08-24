package org.goldstine.otherProblem;

/**
 * 思维题：啤酒问题      非规律化递归问题
 *
 */
public class BeerDemo {
    public static int totalNum;
    public static int lastPingziNum;
    public static int lastGaiziNum;

    public static void main(String[] args) {
        buy(10);
        System.out.println("总数"+totalNum);
        System.out.println("剩余盖子"+lastGaiziNum);
        System.out.println("剩余瓶子:"+lastPingziNum);
    }

    //定义一个买酒的方法
    public static void buy(int money){
        //首先拿钱买就
        int number=money/2;
        //将所有的酒累加起来
        totalNum+=number;

        //算出当前剩余的全部盖子和瓶子数
        int currentPingziNum=lastPingziNum+number;
        int currentGaiziNum=lastGaiziNum+number;

        //把他们换算成金额
        int totalMoney=0;
        totalMoney+=(currentPingziNum/2)*2;

        //算出剩余的瓶子
        lastPingziNum=currentPingziNum%2;

        //将盖子换算成金额
        totalMoney+=(currentGaiziNum/4)*2;
        //算出剩余的盖子
        lastGaiziNum=currentGaiziNum%4;

        if(totalMoney>=2){
            buy(totalMoney);

        }
    }
}
