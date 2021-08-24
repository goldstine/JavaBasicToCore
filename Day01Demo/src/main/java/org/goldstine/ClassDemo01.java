package org.goldstine;

public class ClassDemo01 {

    /**
     * 类中的成分研究：类中有且仅有五大成分
     * （1）成员变量（Field:描述类和对象的属性信息）
     * （2）成员方法（Method:描述类或者对象的行为信息）
     * （3）构造器（Constructor:初始化一个类的对象并返回引用）
     * （4）代码块
     * （5）内部类
     */

    /**
     * 一个类默认自带一个无参数构造器，即使不写它也存在，但是如果一个类它写了一个构造器，那么默认的无参数构造器就被覆盖了
     * 此时如果需要使用无参构造器需要显式声明对应的无参构造器
     */

    /**
     * this关键字的作用：
     *  this代表了当前对象的引用；
     *  this关键字可以用在实例方法和构造器中
     *  this用在方法中，谁调用了这个方法，this就代表了谁
     *  this用在构造器中，代表了构造器正在初始化的那个对象的引用
     */

    /**
     * 封装的规范：
     * （1）建议成员变量都私有：用private修饰
     * （2）提供成套的geter+setter方法暴露成员变量的取值和赋值
     *
     */

    /**
     * static关键字：
     * java中的成员变量有些属于对象，有些属于类本身的，通过static修饰来区分是类还是属于对象的
     * static====静态===修饰的成员（方法或成员变量）属于类本身的
     *
     * 按照有无static修饰，成员变量和方法可以分为：
     *      成员变量：
     *          （1）静态成员变量（类变量） 与类一起加载一次
     *                  有static修饰，属于类本身，直接用类名访问即可  也可以通过对象进行访问，但是不推荐
     *            （2）实例成员变量   与类的对象一起加载，对象加载几次，成员变量就加载几次
     *                  无static修饰，属于类的每一个对象，必须用类的对象来访问
     *       成员方法：
     *             （1）静态方法   属于类本身，直接用类名进行访问即可，也可以使用对象进行共享访问，但是不推荐
     *                 （2）实例方法   属于对象，必须通过对象进行访问
     *
     *        一般静态成员变量随类只加载一次，所以生命的同时最好直接赋初值
     *
     *        静态方法不能够访问实例成员变量
     *
     */
    public static String schoolName="goldstine";
    public String name;
    private int age;
    public static void main(String[] args) {
//        Animal animal = new Animal();
//        animal.setName("金毛");
//        System.out.println(animal.getName());

        //静态成员变量的使用

        System.out.println(ClassDemo01.schoolName);
        System.out.println(schoolName);//同一个类中访问静态成员变量可以省略类名不写
        //在同一各类中访问静态方法也可以省略类名不写
    }

}
//通过插件ptg直接一键生成无参，有参，get,set，toString()
class Animal{
    private String name;
    private int age;
    private char sex;

    public Animal(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Animal(){}

    public String getName() {
        return this.name;//this有时候可以省略不写
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}