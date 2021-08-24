package org.goldstine;

/**
 * 懒汉单例模式         说先要保证单例对象，所以必须通过类静态方法获取
 *通过类获取单例对象的时候发现没有对象才会去创建一个对象
 *
 *
 */
public class SingleInstanceDemo02 {


}
//懒汉单例模式创建一个单例模式类
class SingleInstance02{
    //定义一个静态成员变量用于存储一个对象
    public static SingleInstance02 ins;

    //将构造器私有化
    private SingleInstance02(){

    }

    //定义一个方法返回单例对象
    public static SingleInstance02 getInstance(){
        if(ins==null){//这种方式只能适用于但线程方式的懒汉式单例模式，多线程需要加锁
            //第一次来取对象，创建一个对象
            ins=new SingleInstance02();
        }
        return ins;
    }

    /**
     * 懒汉式的单例模式，在需要的时候动态创建对象
     * 属于一种延迟加载
     * 可以节约性能
     *
     */

}