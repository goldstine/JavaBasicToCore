package org.goldstine.mathclass;

/**
 * 包装类的特殊功能
 *      java为包装类提供一些特殊功能，以便程序员使用
 *      包装类作为类，首先拥有Object类的发方法
 *      包装类作为引用类型的变量可以存储null值
 *
 * 1、可以将基本数据类型的值转换成字符串类型的值
 *          toString()
 *          调用Integer.toString(基本数据类型的值)得到字符串
 *          直接把基本数据类型+空字符串得到字符串
 *
 * 2、把字符串数值转成对应的基本数据类型的值
 *      xxx.parseXxx("字符串类型的数值");   一定是字符串数值，否者抛出NumberFormatException
 *
 *      Xxx.valueOf("字符串类型的数值");
 *
 */
public class PackageClass02 {
    public static void main(String[] args) {
        //基本数据类型转字符串
        Integer it=100;
        String s = it.toString();
        System.out.println(s+1);
        String s1 = Integer.toString(it);
        System.out.println(s1+1);

        String s2 = it + "";
        System.out.println(s2+1);

        //将字符串转为基本数据类型
        String strNum="23";
        int numInt=Integer.parseInt(strNum);
        System.out.println(numInt+1);

        Integer integer = Integer.valueOf(strNum);
        System.out.println(integer+1);

    }
}
