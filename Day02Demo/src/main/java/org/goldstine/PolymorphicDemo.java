package org.goldstine;

/**
 * 封装，继承和多态
 * 多态的形式：
 *      父类类型  对象名称=new 子类构造器();
 *      接口     对象名称=new   实现类构造器();
 *  父类类型的范围>子类类型范围的
 *
 *  多态的概念：
 *  同一个类型的对象，执行同一行为，在不同的状态下会表现出不同的行为特征
 *
 *  多态的识别技巧：
 *      对于方法的调用：编译看左边，运行看右边  运行方法是一种行为，所以为了表现出多态的不同的行为，所以运行方法看右边
 *      对于变量的调用：编译看左边，运行也看左边   变量没有多态，所以统一看左边
 *
 *    多态的使用前提：
 *      （1）必须存在继承或者实现关系
 *      （2）必须存在父类类型的变量引用子类类型的对象
 *      （3）需要存在方法重写
 *
 *
 *      多态的优劣势：
 *      优势：（1）在多态的形式下，右边对象可以实现组件化切换，业务功能也随之改变，便于扩展维护
 *      （2）实际开发过程中，父类类型作为方法形式参数，传递子类对象给方法
 *      可以传入一切子类对象进行方法的调用，更能体现出多态的扩展性与便利
 *
 *      劣势：
 *          （1）多态形式下，不能直接调用子类特有的功能 编译看左边
 *          父类中没有子类独有功能，所以代码在编译阶段就直接报错了
 *
 *
 */
public class PolymorphicDemo {

    public static void main(String[] args) {
//        Animal c = new Cat();//类似于现实生活中的猫也是动物
//        c.run();//🐱跑得飞快
//        System.out.println(c.name);//动物名称Animal
//        Animal d = new Dog();
//        d.run();//🐕跑得很快
//        System.out.println(d.name);//动物名称Animal

        go(new Cat());
        go(new Dog());
    }

    public static void go(Animal a){//通过多态的方式接收参数，在实际开发中使用比较多，传一个实现类
        System.out.println("开始比赛...");
        a.run();
        System.out.println("结束比赛...");
    }

}

class Cat extends Animal{
    public String name="猫的名称";
    @Override
    public void run(){
        System.out.println("🐱跑得飞快");
    }
}
class Dog extends Animal{
    public String name="狗的名称";
    @Override
    public void run(){
        System.out.println("🐕跑得很快");
    }
}

class Animal{
    public String name="动物名称Animal";
    public void run(){
        System.out.println("动物跑！！！");
    }
}