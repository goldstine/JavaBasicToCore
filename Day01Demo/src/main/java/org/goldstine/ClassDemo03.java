package org.goldstine;

/**
 * 子类重写父类的方法，但是还是需要调用父类的被重写方法
 * 通过super在子类进行中转
 *super:代表了父类引用
 */
public class ClassDemo03 {
    public static void main(String[] args) {
        SportMan sportMan = new SportMan();
//        sportMan.run();
        sportMan.go();
    }

}

class SportMan extends People{
    public void run(){
        System.out.println("运动员会跑....");
    }
    //run()被重写，但是如果要访问父类的run()，需要进行中转
    public void go(){
        super.run();//super只有在子类中才有代指父类People     super可以用在子类的实例方法中调用父类被重写的方法
    }
}

class People{
    public void run(){
        System.out.println("人会跑。。。。。");
    }
}