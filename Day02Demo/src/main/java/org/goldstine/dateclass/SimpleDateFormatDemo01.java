package org.goldstine.dateclass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat简单日期格式化类的使用
 *  引入：
 *      之前得到的Date日期对象或者时间毫秒值的时间形式
 *      开发中并不喜欢，不符合有些时间格式的需求
 *
 *  DateFormat作用：
 *      （1）可以将日期对象或时间毫秒数转换为需要的时间形式
 *      （2）可以把字符串的时间形式，再又解析成日期对象
 *
 *    DateFormat是一个抽象类，不能直接使用，要使用它的子类SimpleDateFormat
 *
 *    包java.text.SimpleDateFormat
 *      构造器：
 *          public String format(Date date);可以将日期对象格式化为字符串时间格式
 *          public String format(Object time);可以将时间毫秒值格式化为字符串时间格式
 *          public Date parse(String date);throws ParseExeception:把字符串的时间解析成日期对象
 */
public class SimpleDateFormatDemo01 {
    public static void main(String[] args) {
        //得到此刻日期对象
        Date date = new Date();
        System.out.println(date);

        //创建一个简单日期格式化对象负责格式化日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");//EEE表示星期 a表示上午还是下午

        String format = sdf.format(date);
        System.out.println(format);

    }
}
