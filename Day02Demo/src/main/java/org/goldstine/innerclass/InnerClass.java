package org.goldstine.innerclass;

public class InnerClass {
    public static void main(String[] args) {
        //访问静态内部类,只能通过静态内部类的类名访问静态内部类的静态成员
        System.out.println(Outer.InnerClass.schoolName);

        //创建静态内部类的对象
        Outer.InnerClass zs=new Outer.InnerClass("zhangsan");
        System.out.println(zs.getName());//可以直接通过对象访问静态内部类的实例方法



    }

}

class Outer{
    //静态内部类，有static修饰，属于外部类本身，只会加载一次   就像发动机属于汽车类一样只属于外部类本身

    //正常来说static不能修饰类，只是修饰类的成分，表示属于类，但是可以修饰内部类
    /**
     * 静态内部类的成分：类有的成分他都有
     * 使用方式-访问格式：外部类名称.内部类名称
     * 静态内部类创建对象的方式：
     *      外部类名称.内部类名称  对象名称=new 外部类名称.内部类构造器();
     *
     *  问题：
     *      静态内部类是否可以直接访问外部类的静态成员   =====可以，外部类的静态成员只有一份，可以被共享
     *      静态内部类是否可以直接访问外部类的实例成员   ====== 不可以
     */

    //外部类的静态成员
    public static int age1=12;

    public int age2=13;

    public static class InnerClass{
        private String name;
        private int age;

        //静态内部类同样有静态成员变量
        public static String schoolName="goldstine";

        //静态内部类访问外部类的静态成员
        public void show(){
            System.out.println(age1);//静态内部类可以访问外部类的静态成员
//            System.out.println(age2);//静态内部类不可以直接访问外部类的实例成员
            //外部类的成员属于外部类对象，可以创建外部类对象访问
            Outer outer = new Outer();
            System.out.println(outer.age2);//通过外部类对象访问外部类实例成员
        }


        public InnerClass(String name) {
            this.name = name;
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
    }
}
