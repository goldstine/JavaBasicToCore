package org.goldstine.mathclass;

/**
 * Math类的使用
 * Math用于做数学运算
 * Math类中的方法全部都是静态方法，直接通过类名调用即可    私有构造方法
 *      public static int abs(int a)   获取参数a的绝对值
 *      public static double ceil(double a)   向上取整
 *      public static double floor(double a)  向下取整
 *      public static double pow(double a,double b)获取a的b次幂
 *      public static long round(double a)     四舍五入取整
 */
public class MathDemo {

    public static void main(String[] args) {
        System.out.println(Math.abs(-12));//12
        System.out.println(Math.ceil(4.0000001));//5.0
        System.out.println(Math.floor(4.9999999)); //4.0
        System.out.println(Math.pow(2,3));//8.0
        System.out.println(Math.round(4.4999999));//4
        System.out.println(Math.round(4.500001));//5
    }

}
