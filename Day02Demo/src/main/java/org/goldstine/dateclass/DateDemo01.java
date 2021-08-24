package org.goldstine.dateclass;

import java.util.Date;

/**
 * java是面向对象的，会用一个类表示一个事务
 * Date类在java中代表的是系统当前此刻日期时间对象
 *  Date类：
 *      包：java.util.Date
 *         构造器
 *              public Date():创建当前系统的此刻当前日期时间对象
 *          ----public Date(long time)  //表示从源头开始的毫秒数     将时间毫秒数转为日期对象
 *          方法----public long getTime()返回自1970年1月1日 00：00：00GMT以来走过的总的时间
 *
 *          时间毫秒数的作用：时间毫秒数可以用于做时间的计算，比如代码的执行性能分析
 *
 */
public class DateDemo01 {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);//默认是调用的date.toString(),这里输出的是内容而不是地址，所以说明Date类重写了toString()
        System.out.println(date.getTime());

        Date date1 = new Date(10);
        System.out.println(date1);
        System.out.println(date1.getTime());

        //时间毫秒值做性能分析
        long startTime=new Date().getTime();

//        for (int i = 0; i < 1000000; i++) {
//            System.out.println("输出:"+i);
//        }

        long endTime=new Date().getTime();

        System.out.println((endTime-startTime)/1000.0);

    }

}
