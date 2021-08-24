package org.goldstine.mathclass;

import java.math.BigDecimal;

/**
 * BigDecimal大数据类
 * 浮点型运算的时候+ * /可能会出现数据丢失的问题（精度问题）
 * BigDecimal可以解决浮点型运算数据失真的问题
 *
 *  //创建对象的方式public static BigDecimal valueof(double val);包装浮点数成为大数据对象
 *      包 Java.math
 *      public BigDecimal add(BigDecimal value);  加法运算
 *      public BigDecimal  substract(BigDecimal value) 减法运算
 *      public BigDecimal multiply(BigDecimal value)   乘法运算
 *      public BigDecimal divide(BigDecimal value)     除法运算
 *      public double doubleValue();将BigDecimal类型转为double类型
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        System.out.println(0.1+0.2);
        System.out.println(0.09+0.01);
        System.out.println(1.0-0.32);
        System.out.println(1.015*100);
        System.out.println(1.301/100);

        double a=0.1;
        double b=0.2;
        double c=a+b;
        System.out.println(c);

        BigDecimal a1=BigDecimal.valueOf(a);

        BigDecimal b1=BigDecimal.valueOf(b);

        BigDecimal c1=a1.add(b1);

        System.out.println(c1);//BigDecimal类重写了toString()

        BigDecimal d1=a1.divide(b1);
        System.out.println(d1);

        //注意：实际开发中BigDecimal只是解决精度问题的手段，double数据才是我们的目的

        double rs=c1.doubleValue();  //使用的时候还是使用double,所以将BigDecimal类型转为double类型的方式
        System.out.println(rs);

    }
}
