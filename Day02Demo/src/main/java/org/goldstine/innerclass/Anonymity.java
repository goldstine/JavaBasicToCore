package org.goldstine.innerclass;

/**
 * 测试匿名内部类:
 *          就是一个没有名字的局部内部类
 *          匿名内部类可以简化代码，也是开发中常用的形式
 *  匿名内部类的使用格式：
 *      new 类名|抽象类|接口（形参）{
 *          方法重写。
 *      }
 *
 *   匿名内部类的特点：
 *      （1）匿名内部类是一个没有名字的内部类
 *      （2）匿名内部类一旦写出来就会立刻创建匿名内部类对象返回
 *      （3）匿名内部类的对象类型相当于是当前new的那个类型的子类类型
 */
public class Anonymity {

    public static void main(String[] args) {
//        Animal a=new Cat();
//        a.run();
//        a.go();
        //使用匿名内部类的方式，直接new 父类();
        Animal a=new Animal(){//是一个匿名内部类，也是一个对象
//反编译之后还是一个类，所以是当做一个类看待
            @Override
            public void run() {
                System.out.println("匿名内部类的方式重写该run方法。。。。");
            }
        };
        a.run();
        a.go();
    }

}

class Cat extends Animal{

    @Override
    public void run() {
        System.out.println("猫跑的很快。。。。。");
    }
}


//创建一个抽象类
abstract class Animal{
    public abstract void run();
    public void go(){
        System.out.println("goldstine");
    }
}
