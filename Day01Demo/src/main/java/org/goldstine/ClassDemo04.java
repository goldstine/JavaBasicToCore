package org.goldstine;

/**
 * 静态方法和私有方法是否可以被重写
 *子类不能够重写父类的私有方法
 * 子类不能够重写父类的静态方法    加上@Override都报错
 */

/**
 * 继承后构造器的特点：
 * 子类构造器默认一定会先访问父类的无参构造器，再执行子类自己的构造器
 * //子类构造器默认会调用父类无参构造器的原因是，默认子类构造器的第一行有一个super()调用
 *      这是由继承关系所决定的，调用子类构造器初始化子类对象数据的时候，必须先调用父类构造器初始化继承自父类的属性和行为
 */

/**
 * super调用父类构造器
 *
 *  特点：
 *  子类全部构造器默认一定会调用父类的无参构造器
 *  为了避免父类的无参构造器被有参构造器覆盖，所以一般会在父类中显示准备一个无参构造器
 *
 *  super(xxx)：可以根据参数选择调用父类的某个构造器
 *可以在子类构造器中通过super(xxx)根据参数选择调用父类的构造器，以便调用父类的构造器初始化继承自父类的数据
 */


/**
 * this   可以用于父类构造方法中，代表当前初始化的对象
 * 调用兄弟构造器的功能
 */

/**
 *
 */

public class ClassDemo04 {
    public static void main(String[] args) {
        dog dog = new dog("孙悟空",10, '男');
        dog.eat();

    }
}

class dog extends Animal02{
    public dog(String s, int i, char man) {
        super(s,i,man);//super通过参数选择调用父类的有参构造器，原因是对应的成员变量在父类中
    }

    public void eat(){
       System.out.println(getName()+"---------->"+getAge()+"---------->"+getSex());
   }
}

class Animal02{
    private String name;
    private int age;
    private char sex;

    public Animal02(){}

    public Animal02(String name, int age, char sex) {
        this();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
