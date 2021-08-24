package org.goldstine.regex;

/**
 * 正则表达式：很适合做校验
 * 同样也是jdk的Pattern类提供正则表达式的规则
 *
 * [abc] a,b或c(简单类)
 * [^abc]任何字符，除了a,b或c（否定）
 * [a-zA-Z]a到z  或A到Z  两头的字母包括在内
 *
 *
 * 预定义字符类
 *       。任何字符
 *       \d数字：[0-9]
 *       \D非数字：[^0-9]
 *       \s空白字符：[ \t\n\X0B\f\r]
 *       \S非空白字符：[^\s]
 *       \w单词字符：[a-zA-Z_0-9]
 *       \W非单词字符[^\w]
 *
 *
 * 数量词
 *      X? X:表示一次或一次也没有
 *      X* X:表示零次或多次
 *      X+ X:表示一次或多次
 *      X{n} X：恰好n次
 *      X{n,} X:至少n次
 *      X{n,m} X,至少n次，但是不超过m次
 */
public class RegexDemo01 {
    public static void main(String[] args) {
        System.out.println("a".matches("[abc]"));//true
        System.out.println("z".matches("[abc]"));//false
        System.out.println("a".matches("[^abc]"));//false
        System.out.println("z".matches("[^abc]"));//true

        System.out.println("a".matches("\\d"));//false
        System.out.println("12".matches("\\d"));//false   默认只能校验一个
        System.out.println("3".matches("\\d"));//true
        System.out.println("z".matches("\\w"));//true
        System.out.println("2".matches("\\w"));//true
        System.out.println("12".matches("\\w"));//false     //"\\w"只能校验一个，表示字母数字下划线
        System.out.println("你".matches("\\w"));//false


        //校验密码
        //必须是数字  字母  下划线  至少6位
        System.out.println("ssds3c".matches("\\w{6,}"));//true
        System.out.println("ssdsc".matches("\\w{6,}"));//false

        //校验验证码   必须是数字和字符  必须是4位
        System.out.println("asa1".matches("[a-zA-Z0-9]{4}"));//true
    }
    //用正则表达式
    public static boolean checkQQRegex(String qq){
        return qq!=null && qq.matches("\\d{4,}");//表示4位以上的数字
        //matches是字符串提供的正则表达式匹配的方法

    }

}
