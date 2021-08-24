package org.goldstine;

import java.util.Scanner;

public class ExceptionTest {
    //输入一个整数,直到输入一个合法的年龄为止
    public static void main(String[] args) {

        while(true){
            try {   //InputMismatchException 运行时异常
                Scanner scanner = new Scanner(System.in);
                System.out.println("请您输入你的年龄：");
                int age = scanner.nextInt();
                System.out.println("您是：" + age);
                break;
            }catch(Exception e){
                System.err.println("您的年龄是下输入的");
            }
        }

        //可以用于输入校验  数据校验可以使用正则表达式和异常方式
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入添加书本的价格：");
                String price=scanner.nextLine();
                //将字符串转为整形
                double priceDouble = Double.valueOf(price);
                break;
            }catch(Exception e){
                System.err.println("价格格式不对！请检查");
            }
        }

    }
}
