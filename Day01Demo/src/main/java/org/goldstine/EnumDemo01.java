package org.goldstine;

/**
 * 枚举类：面向对象的特殊类型
 *
 * 枚举是用于做信息标志和信息分类
 *      枚举类的格式：
 *          修饰符(public)  enum  枚举名称{
 *              第一行必须是罗列类的对象名称  实例1名称，实例2名称，。。。。
 *
 *          }
 *
 * 枚举类的特点：
 *
 */
enum Oritation{
    UP,DOWN,LEFT,RIGHT;
}

public class EnumDemo01 {

    public static void main(String[] args) {
        Sex boy = Sex.BOY;
        Sex girl = Sex.GIRL;
        System.out.println(boy);//这里输出对象的引用，输出的是内容
        System.out.println(girl);//这里输出枚举对象的引用，输出的是内容GIRL,不是输出的地址
        System.out.println(boy.ordinal());//枚举对象的索引位置  0
        System.out.println(girl.ordinal()); //枚举对象的索引位置  1

        move(Oritation.LEFT);

    }

    public static void move(Oritation oritation){
        switch(oritation){   //switch中可以自动识别枚举类中的实例对象，所以直接使用枚举类是里对象的对象名
            case UP:
                System.out.println("向上");
                break;
            case DOWN:
                System.out.println("向下");
                break;
            case LEFT:
                System.out.println("向左");
                break;
            case RIGHT:
                System.out.println("向右");
                break;
        }
    }

}

enum Sex{
    BOY,GIRL;
}
/**
 * 枚举类对应的反编译的java程序为：
 * D:\goldstine>javap Sex.class
 * Compiled from "Sex.java"
 * public final class Sex extends java.lang.Enum<Sex> {
 *   public static final Sex BOY;
 *   public static final Sex GIRL;
 *   public static Sex[] values();
 *   public static Sex valueOf(java.lang.String);
 *   static {};
 * }
 *
 * 1、枚举类的特点：
 *      （1）枚举类是final修饰的，不能被继承
 *      （2）枚举类默认继承了枚举类型java.lang.Enum
 *      (3)枚举类的第一行罗列的是枚举类对象，而且使用常量存储的
 *      （4）所以枚举类的第一行写的都是常量名称，默认存储了枚举对象
 *      （5）枚举类相当于是多例对象
 *      （6）枚举类的构造器默认是私有的
 *      （7）枚举类相当于是多例模式
 */
