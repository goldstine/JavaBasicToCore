package org.goldstine.compaileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * try:出现一次
 * catch出现0到n次
 * finally:0-1次    无论代码时出现异常还是正常执行，最终一定要执行这里的代码
 *
 *
 * 小结：
 * （1）运行时异常被抛出可以不处理，可以自动抛出，编译时异常必须处理，按照规范都应该处理
 * （2）重写方法申明抛出的一场，应该与父类的被重写方法声明抛出的一场一样或者范围更小
 * （3）方法默认都可以自动跑出运行时异常，throws RuntimeException可以省略不写
 * （4）当多异常处理时，捕获处理前面的异常类不能是后边异常类的父类
 * （5）try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收
 *
 *
 */
public class ExceptionDemo03 {
    public static void main(String[] args) {
        int run = run();
        System.out.println(run);
    }
    public static int run(){
        InputStream is=null;
        try{
            int a=10/2;
//            System.out.println(10/0);
//            is=new FileInputStream("D:\\goldstine\\gittest");
//            System.out.println(10/0);

//            System.exit(0);

            return a;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            System.out.println("========finnaly被执行=========");
            //回收资源，用于在代码执行完毕之后进行资源的回操作
//            if(is!=null){
//                try {
//                    is.close();//有可能is对象还没有创建出来，所以需要做一个非空校验
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

            return 1212;  //不建议在finally中写return,会覆盖前面所有的return值


        }
    }
}
