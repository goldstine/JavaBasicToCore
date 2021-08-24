package org.goldstine.dateclass;

import java.util.Calendar;
import java.util.Date;

/**
 * 日历类Calendar使用
 *      Calendar代表了系统此刻日期对应的日历对象
 *      Calendar是一个抽象类，不能直接创建对象
 *
 *
 *   Calendar日历类创建日历对象的语法
 *          Calendar rightNoe=Calendar.getInstance();
 *
 *          Calendar的方法：
 *          （1）public static Calendar getInstance():返回一个日历类对象
 *          (2)public int get(int field):取日期中的某个字段信息
 *          （3）public void set(int field,int value):修改日历的某个字段信息
 *          （4）public void add(int field,int amount);为某个字段增加/减少指定的值
 *          (5)public final Date getTime():拿到此刻日期对象
 *          (6)public long getTimeInMillis();拿到此刻时间毫秒值
 */
public class CalendarDemo01 {

    public static void main(String[] args) {
        //通过日历类的静态方法直接获得一个日历对象
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        //获取年
        int year = instance.get(Calendar.YEAR);
        System.out.println(year);
        int month = instance.get(Calendar.MONTH)+1;
        System.out.println(month);
        //一年中的第几天：308
        int days = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //修改日历信息
//        instance.set(Calendar.YEAR,2099);
//        System.out.println(instance.get(Calendar.YEAR));

        //可以让日历往后走多少天，问367天后的时间
        instance.add(Calendar.DAY_OF_YEAR,701);


        //日历可以得到此刻日期对象
        Date time = instance.getTime();
        System.out.println(time);
        //此刻时间毫秒值
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(timeInMillis);


    }

}
