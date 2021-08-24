package org.goldstine;

/**
 * jdk8之前，接口全部都是抽象方法    jdk8之前，接口中时常量和抽象方法，必须重写接口中的所有方法
 * 接口同样不能创建对象
 */
public interface InterfaceDemo01 {
    //抽象方法
    //接口中的抽象方法可以省略public abstract不写，默认会加上
    public abstract void run();//void run();接口中的抽象方法都是确定的
    //因为都是抽象方法，所以必须有abstract   ,必须要被子类重写，所以必须可以重写 public 私有方法和静态方法不能被重写

    //常量，加static表示属于类本身，一般不进行更改，但是可以改，加上final一定不能改
    //常量，变量值只有一个，而且在程序运行过程不可更改，常量修饰符一般是 public static final 缺一不可
    //常量的变量名称建议字母全部大写，多个单词用_连接
    public static final String SCHOOL_NAME="stine";
    //接口中可以省略public static final
    String NAME="liulei";

//    public void run(){}  //jdk8之前接口中不能有实例方法
}


//一个类实现多个接口，必须重写完全部接口中的全部抽象方法，否则这个类要定义成抽象类