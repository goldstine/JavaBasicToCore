package org.goldstine.compaileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 编译时异常的处理机制一：
 * 解决编译时异常的方式，直接抛出异常
 * 出现异常的地方蹭蹭将异常对象跑出去给调用者，调用者最终将异常对象抛给jvm虚拟机
 * jvm虚拟机输出异常信息，直接干掉程序，这种方式与默认的方式是一样的
 * 虽然可以解决编译时代码错误，但是一旦运行时真的出现异常，程序还是会立即死亡
 * 这种方式并不好
 *
 * 只会抛出第一个异常，jvm就结束了
 *
 * 方式二：再出现异常的地方自己处理，谁出现，谁处理
 *
 * 方式三：
 *      在出现异常的地方把异常一层一层地抛出给最外层调用者，最外层调用者集中捕获处理
 *     这种方式最外层调用者可以知道底层执行的情况，同时程序在出现异常之后也不会立即死亡，这是理论上最好的方案
 *
 *
 * 运行时异常的处理：
 *      运行时异常是自动往外抛的，不需要手工抛出
 *
 *
 */
public class ExceptionDemo01 {
//    public static void main(String[] args) throws ParseException {
//        System.out.println("程序开始。。。。。");
//        parseDate("2021-03-01 10:21:45");
//        System.out.println("程序结束。。。。。");
//    }
//    public static void parseDate(String time) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        Date d = sdf.parse(time);//通过SimpleDateFormat将字符串转成日期对象
//        System.out.println(d);
//
//
//    }

//    public static void main(String[] args) {
//        System.out.println("程序开始。。。。。");
//        parseDate("2021-03-01 10:21:45");
//        System.out.println("程序结束。。。。。");
//    }
//    public static void parseDate(String time)  {
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//            Date d = sdf.parse(time);//通过SimpleDateFormat将字符串转成日期对象
//            System.out.println(d);
//
//            FileInputStream fis = new FileInputStream("D:\\goldstine\\gittest");
//
//        } catch (FileNotFoundException e) {
//
//            System.out.println("文件根本不存在");
//        } catch (ParseException e) {
//            System.out.println("解析有问题，请检查代码");
//        }
//
//    }

    //方案三

    public static void main(String[] args)  {
        System.out.println("程序开始。。。。。");
        try {
            parseDate("2021-03-01 10:21:45");
            System.out.println("底层功能成功执行");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("底层执行失败");
        }
        System.out.println("程序结束。。。。。");
    }
    public static void parseDate(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date d = sdf.parse(time);//通过SimpleDateFormat将字符串转成日期对象
        System.out.println(d);


    }
}
