package org.goldstine;

/**
 * 继承的作用：
 *          可以提高代码的复用，相同代码可以定义在父类中
 *     子类不能继承父类的内容：
 *     （1）子类不能继承父类的构造器，子类有自己的构造器（没有争议的）
 *     有争议的观点：
 *     （1）子类是否能继承父类的私有成员（私有成员变量，私有成员方法），子类最起码有一个空参构造器，没有必要继承父类的构造器
 *              子类不能继承父类的私有成员变量和私有成员方法【错】
 *              实际是，子类可以继承父类的私有成员变量和私有成员方法。只不过不能直接进行访问，可以通过反射技术进行访问
 *     （2）子类是否可以继承父类的静态成员
 *              子类可以访问父类的静态成员变量和成员方法，但是是属于共享访问，不是继承关系
 *
 *
 *         继承的访问规则：
 *         如果子类也有和父类相同的字段，子类对象的访问结果是子类的成员变量【就近原则】
 *
 */
public class ClassDemo02 {
    public static void main(String[] args) {
        cat c = new cat();
//        c.show();

        c.run();

    }
}

class cat extends Animal01{
    public String name="子类名称";
    public void show(){
        String name="局部名称";
        System.out.println(name);
        System.out.println(this.name);//根据就近原则进行访问,如果要避免就近原则，需要访问子类的成员变量，这通过this访问
        System.out.println(super.name); //如果要访问父类的name
    }

    public Integer run(){    //子类重写方法的返回值类型声明要么与父类一样，要么比父类方法返回值类型范围更小
        System.out.println("猫跑的很快。。。。。");
        return 1;
    }


}

class Animal01{
    public  String name="goldstine";
    protected   Object run(){
        System.out.println("动物可以跑。。。。。");
        return null;
    }
}


/**
 * 继承后成员方法的访问特点
 *  也是就近原则
 */


/**
 * 方法重写：
 * 子类重写方法的名称和形参列表必须与父类被重写方法一样
 * //子类重写方法的返回值类型声明要么与父类一样，要么比父类方法返回值类型范围更小
 * 子类重写方法的修饰符权限应该与父类被重写方法的修饰符权限相同或者更大
 * 子类重写方法声明抛出的议程应该与父类被重写方法声明抛出的异常一样或者发布为更小
 */
