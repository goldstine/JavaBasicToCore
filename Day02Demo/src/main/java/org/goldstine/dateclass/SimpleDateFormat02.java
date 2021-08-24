package org.goldstine.dateclass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class SimpleDateFormat02 {

    public static void main(String[] args) {
        //121秒之后的时间是多少
        Date date = new Date();
        System.out.println(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String format = sdf.format(date.getTime() + 121 * 1000);
        System.out.println(format);
    }

}
