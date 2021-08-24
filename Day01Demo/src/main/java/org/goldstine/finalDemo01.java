package org.goldstine;

/**
 * final关键字：
 *  fianl可以用于修饰类，方法【成员方法】 ，变量【成员变量和局部变量】
 *String类通过final修饰     final修饰的类和方法可以实现商标保护，只能使用该类和方法
 *  （1）final修饰类，类不能被继承了
 *  （2）final修饰方法，方法不能被重写
 *  （3）final修饰变量，变量有且仅能赋值一次
 *          final修饰局部变量：该变量不希望在代码块中发生改变
 *          final修饰静态变量：public static final 变量变成常量，常量名大写
 *
 *          final修饰静态成员便俩个可以在哪些地方赋值一次：
 *          （1）定义的时候赋值一次
 *          （2）可以在静态代码块中赋值一次
 *         final修饰实例成员变量
 *          final修饰实例成员变量可以在哪些地方赋值1次：
 *              （1）定义的时候赋值一次
 *              （2）可以在实例代码块中赋值一次
 *              （3）可以在每个构造器中赋值一次，【注意，这里是在每一个构造器中都可以做一次赋值，但是还是对该变量赋值一次~！！！！】
 *
 *  abstract与final互斥关系，不能同时出现修饰成员
 */

public class finalDemo01 {
//    public static final String SCHOOL_NAME="goldstine";
    public static final String SCHOOL_NAME;

    //实例成员变量
//    public final String name="liulei";
    public final String name;
    {
        //实例成员变量可以在实例代码块中赋值一次
//        name="goldstine";
    }

    public finalDemo01(){
        this.name="goldstine";//final修饰实例成员变量可以在构造方法中赋值一次
    }

    static{
        SCHOOL_NAME="liulei";
    }

    public static void main(String[] args) { //main()可以执行多次
        //public static final不能在其他地方赋值
//        SCHOOL_NAME="liulei";
    }


}
