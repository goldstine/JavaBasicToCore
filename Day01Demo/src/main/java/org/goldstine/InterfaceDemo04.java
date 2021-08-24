package org.goldstine;

/**
 * (1)如果实现了多个接口，多个接口中存在同名的静态方法不会发生冲突；
 *  原因是只能通过各自接口名访问静态方法
 *
 *  （2）当一个类继承父类的成员方法与实现的接口的方法重名时，子类的对象会优先调用父类的成员方法【遵循就近原则】
 *
 *  （3）当一个类实现多个接口时，多个接口中存在同名的默认方法，实现类必须重写这个方法[也可以在父类中重写，然后继承获得该重写方法]
 *
 *  （4）接口中，没有构造器，不能创建对象{重点}    区别于抽象类全都有，但是也不能创建对象
 *          相比较于抽象类，接口是彻底的抽象，连构造器都没有，自然不能创建对象！！！
 *
 *
 *          【比较】接口和抽象类
 *              （1）都有抽象方法，都不能够创建对象
 *              （2）抽象方法有构造器，成员变量，成员方法，代码块，内部类
 *                  但是接口只有常量和抽象方法等  没有构造器
 *               （3）抽象类只能被单继承，接口可以被多实现
 *
 */
public class InterfaceDemo04 {

    public static void main(String[] args) {
        D d = new D();
        d.run();
    }
}

class D extends C implements A,B{

    @Override
    public void run() {
        System.out.println("当多个实现的接口中有同名的默认方法，实现类必须重写该默认方法");
    }
}

class C{
    public  void run(){
        System.out.println("父类方法与实现接口的方法重名，就近调用父类的同名方法。。。。。");
    }
}

interface A{
    default void run(){
        System.out.println("goldstine");
    }
}
interface B{
    default void run(){
        System.out.println("liulei");
    }
}