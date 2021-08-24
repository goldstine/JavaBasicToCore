package org.goldstine.regex;

import java.util.Scanner;

public class RegexDemo02 {
    public static void main(String[] args) {
//        checkEmail();
//        checkTel();
        checkPhone();
    }
    //校验邮箱
    public static void checkEmail(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入邮箱:");
        String s = sc.nextLine();
        if(s.matches("\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2}")){
            System.out.println("邮箱合法了！");
        }else{
            System.err.println("邮箱格式不正确！");
        }
    }
    //校验手机号
    public static  void checkTel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号码：");
        String s = sc.nextLine();
        if(s.matches("1[3-9]\\d{9}")){
            System.out.println("手机号码格式正确");
        }else{
            System.err.println("手机号码不正确");
        }
    }


    public static  void checkPhone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入电话号码：");
        String s = sc.nextLine();
        if(s.matches("0\\d{2,5}-?\\d{5,15}")){
            System.out.println("手机号码格式正确");
        }else{
            System.err.println("手机号码不正确");
        }
    }
}
