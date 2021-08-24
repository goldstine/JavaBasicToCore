package org.goldstine;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码块：按照是否有static，分为静态代码块和实例代码块
 *
 * 静态代码块格式：
 *      static{}  必须用static修饰，属于类，会与类一起加载，而且自动触发执行一次
 *      静态代码块可以用于执行类的方法之前进行静态资源的初始化操作
 *
 *  实例代码块
 *  格式：{}
 *  必须无static修饰，属于类的每个对象的，会与类的每个对象一起加载，每次创建对象的时候，实例代码快就会触发执行一次
 *  实例代码块可以用于初始化实例资源
 *  实例代码块实际上实体渠道每个构造器中去执行的【效果一样】
 *
 */

public class CodeBlockDemo01 {
//定义一个集合存放54张牌，一个可以定义为static,通过静态代码块进行初始化
    public static List<String> cards=new ArrayList<String>();
    static{//静态资源初始化
        System.out.println("静态代码块执行一次"); //静态代码块和类一起加载执行，并且优于main方法先执行
        //进行初始化操作
        cards.add("红心3");
        cards.add("红心4");
    }

    //实例代码块
    {
        System.out.println("实例代码块在初始化对象的时候执行一次"); //每次创建对象实例代码块都会执行一次
    }

    public static void main(String[] args) {
        System.out.println("main方法执行一次");
        
        //创建对象的时候实例代码块执行一次
        CodeBlockDemo01 codeBlockDemo01 = new CodeBlockDemo01();
        CodeBlockDemo01 codeBlockDemo02 = new CodeBlockDemo01();
    }
}
