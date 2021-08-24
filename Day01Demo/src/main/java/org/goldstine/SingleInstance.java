package org.goldstine;

/**
 * 单例设计模式
 * 单例的意思就是一个类永远只存在一个对象，不能创建多个对象
 *
 * 为什么要用单例？
 *      开发中很多类的对象只需要一个，例如虚拟机对象，任务管理器对象
 *      对象越多越占内存，有些时候只需要一个对象就可以实现业务，单例可以节约内存，提高性能
 *
 *如何实现单例：
 * 单例的实现方式有8种，目前有2种方式实现单例模式：饿汉式，懒汉式
 * （1）饿汉式单例模式
 *          通过类获取单例对象的时候，对象已经提前准备好了
 *          实现方式：手写
 *          （1）定义一个单例类
 *          （2）把类的构造器私有
 *          （3）定义一个静态成员变量存储单例对象
 *          （4）对外提供getInstance()方法将该静态成员变量返回
 */
public class SingleInstance {
    public static void main(String[] args) {
        SingleInstance01 instance01 = SingleInstance01.getInstance();
        SingleInstance01 instance02 = SingleInstance01.getInstance();
        System.out.println(instance01==instance02);//true,说明instance01和instance02是同一个对象

    }
}

//饿汉式单例设计一个单例类
class SingleInstance01{
    //2、定义一个静态成员变量用于存储一个对象,静态成员变量只能有1个
    //饿汉单例在返回对象的时候，对想要已经做好，所以这里直接创建出来
    public static SingleInstance01 ins=new SingleInstance01();//静态成员变量在加载这个类的时候就已经创建好了

    //1、把构造器私有化
    private SingleInstance01(){

    }

    //3.提供一个方法返回单例对象
    public static SingleInstance01 getInstance(){
        return ins;
    }
}