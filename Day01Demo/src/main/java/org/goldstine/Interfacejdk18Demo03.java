package org.goldstine;

/**
 * jdk1.8开始之后新增的三个方法，是sun为了支持后面的lamda表达式 stream  函数式接口
 *
 *      jdk1.8之前接口中只能是抽象方法和常量
 *      jdk1.8开始之后接口不再纯洁
 *      jdk1.8开始之后接口新增了三个方法：
 *          接口中的方法和常量默认都是public 能省就省 为了实现类继承
 *          （1）默认方法 其实就是我们之前写的实例方法    --必须用default修饰，默认会加public
 *          由于接口没有实现类，所以默认方法只能通过接口的实现类的对象调用
 *          （2）静态方法
 *          可以直接加static修饰
 *          默认会加public修饰
 *          接口的静态方法只能用接口的名称调用，【不能通过实现类调用，区别于子类可以调用父类的静态方法】
 *          （3）私有方法[jdk1.9才开始支持]
 *          其实就是私有的实例方法 必须加private
 */

public class Interfacejdk18Demo03 {
    public static void main(String[] args) {
        PingPongMan zjk=new PingPongMan();
        zjk.run();
//        zjk.show();//接口的静态方法不能通过实现类的对象调用 ，区别于子类调父类的静态方法
        SportMan03.show();//接口的静态方法必须通过接口名调用
    }

}
class PingPongMan implements SportMan03{

}
interface SportMan03{
    public default void run(){ //默认方法   //public灰色，默认会加上，所以可以省掉public
        System.out.println("goldstine");
    }
    public static void show(){
        System.out.println("接口的静态方法必须要通过接口名调用，子类可以调用父类的静态方法，子类不能访问父类的私有方法。子类不能重写父类的静态方法和私有方法");
        System.out.println("这里还是关于继承的哪些可以被子类继承，继承之后的重写方法的访问顺序");
    }
//    private void read(){  //jdk1.8不支持。jdk1.9才开始支持
//
//    }
}


/**
 * 文档注释可以被提取都产品说明书中去
 */

