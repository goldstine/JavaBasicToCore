package org.goldstine.regex;

/**
 * 正则表达式在方法中的应用
 *      public String[] split(String regex):
 *          --按照正则表达式匹配的内容进行分割字符串，返回一个字符串数组
 *      public String replaceAll(String regex,String newStr);
 *              ---按照正则表达式的匹配内容进行替换
 *
 *
 */
public class RegexDemo04 {
    public static void main(String[] args) {
        //1、split的基础用法
        String names="贾乃亮,王宝强,陈羽凡";
        //以，分割
        String[] nameArrs=names.split(",");

        for (int i = 0; i < nameArrs.length; i++) {
            System.out.println(nameArrs[i]);
        }

        //2、split集合正则表达式做分割
        String name1="贾乃亮12132324王宝强129_23sa82783陈羽凡";
        //split(regex);以匹配正则表达式的内容作为分割点分割成字符串数组
        String[] nameArr1=name1.split("\\w+");
        for (int i = 0; i < nameArr1.length; i++) {
            System.out.println(nameArr1[i]);
        }


        //replaceAll()
        //public String replaceAll(String regex,String newStr)
        //使用正则表达式定位出内容，替换成/
        String name2="贾乃亮12132324王宝强129_23sa82783陈羽凡";
        System.out.println(name2.replaceAll("\\w+","/"));

        //如果可以直接替换就没有比要正则表达式
        String name3="贾乃亮,王宝强,陈羽凡";
        System.out.println(name3.replaceAll(",","/"));
    }
}
