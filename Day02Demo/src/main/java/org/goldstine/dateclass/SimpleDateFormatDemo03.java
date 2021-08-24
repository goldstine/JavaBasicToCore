package org.goldstine.dateclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将字符串时间形式转换成日期对象
 *
 */
public class SimpleDateFormatDemo03 {
   //面试题：请问"2019-11-04 09:30:30"往后1天15小时，30分29秒后的时间是多少
   public static void main(String[] args) throws ParseException {
        //1、定义一个字符串时间
       String date="2019-11-04 09:30:30";
       //2、把字符串的时间解析成Date日期对象
       //创建一个简单日期格式化对象负责解析字符串的事件成为日期对象
       //注意：参数必须与被解析的时间的格式完全一致，否则执行报错！！！！
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date parse = sdf.parse(date);
       //3、得到日期对象的时间毫秒值+往后走1天15小时，30分29秒
       long l = parse.getTime() + (24L + 15) * 60 * 60 * 1000 + (30 * 60 + 29) * 1000;

       //4、吧时间毫秒值格式化成需要的字符串时间形式
       String format = sdf.format(l);
       System.out.println(format);
   }

}
