package org.goldstine;


/**
 * 引用类型作为方法的参数和返回值     【引用类型：除了基本数据类型就是引用数据类型】
 * 引用数据类型作为成员变量
 */

/**
 * 拥有抽象方法的类必须定义为抽象类
 * 子类继承父类，必须要重写父类的抽象方法
 * 注意：一个类继承了抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类
 */

/**
 * 抽象类的特征：有得有失
 *      有得：抽象类得到了拥有抽象方法的能力，所以只是得到拥有抽象方法的能力，但是抽象类可以没有抽象方法
 *      有失：抽象类失去了创建对象的能力
 *
 *   面试题：抽象类是否有构造器，抽象类是否可以创建对象？
 *          答：抽象类作为类一定有构造器，而且抽象类必须有构造器
 *              提供给子类创建对象调用父类构造器使用的
 *
 *              抽象类虽然有构造器，但是抽象类不能创建对象？
 *              反证法：加入抽象类可以创建对象
 *              Animal a=new Animal();
 *              a.run();//抽象方法不能执行，因为它没有方法体，所以抽象类不能创建对象
 *
 *              抽象本身就是抽象，本身不能具体化
 *
 *               //抽象方法可以有实例成员变量和实例成员方法，通过继承给子类使用
 *
 *               抽象类具有类的所有成分：5大成分：成员变量，成员方法，构造器，方法体，内部类
 */

/**
 * 抽象类存在的意义：
 *      1、抽象类的意义就是为了被子类继承（就是为了派生子类），否则抽象类毫无意义
 *      2、抽象类体现的是模板思想，部分实现，部分抽象，可以设计模板设计模式
 *
 */


public class ClassDemo05 {
    public static void main(String[] args) {
//        new Animal03();//抽象类不能初始化对象

    }

}

abstract class Animal03{     //抽象方法可以有实例成员变量和实例成员方法，通过继承给子类使用
    public String name;

    //构造器
    public Animal03(){}

    public void run(){
        System.out.println("goldstine");
    }

    public static void show(){
        System.out.println("lilei");

    }

    public String getName(){
        return name;
    }
    //抽象方法
    public abstract void read();
}

