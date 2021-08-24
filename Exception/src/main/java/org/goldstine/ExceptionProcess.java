package org.goldstine;

/**
 * 一场的产生和处理过程：
 *(1)首先会在出现异常的地方产生一个异常对象
 * （2）然后将该异常对象交给该方法
 * （3）然后通过栈结构，将该异常对象继续交给调用方法
 * （4）最终将该异常对象交给main()
 * (5)将异常对象交给jvm虚拟机，打印异常栈信息，虚拟机结束程序
 */
public class ExceptionProcess {
    public static void main(String[] args) {
        System.out.println("程序开始。。。。。。。。。");
        divide(10,0);
        System.out.println("程序结束...............");

    }
    public static void divide(int a,int b){
        System.out.println(a);
        System.out.println(b);
        int c=a/b;         //产生异常，运行时异常，会自动创建异常对象：ArihmeticException
        System.out.println("结果是:"+c);
    }
}
