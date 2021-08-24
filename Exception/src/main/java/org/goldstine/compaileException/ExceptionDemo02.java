package org.goldstine.compaileException;

/**
 * 运行时异常的处理
 *      只需要在最外层的调用方法进行异常捕获即可，内层的异常会自动进行抛出的
 */
public class ExceptionDemo02 {
    public static void main(String[] args) {
        System.out.println("程序开始。。。。。。。。。");
        try {
            divide(10, 0);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("程序结束...............");

    }
    public static void divide(int a,int b){
        System.out.println(a);
        System.out.println(b);
        int c=a/b;         //产生异常，运行时异常，会自动创建异常对象：ArihmeticException
        System.out.println("结果是:"+c);
    }
}
