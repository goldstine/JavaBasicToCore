package org.goldstine.innerclass;

/**
 * 成员内部类（实例内部类）
 *  无static修饰的内部类，属于外部类的每一个对象的，与对象一起加载的
 *      实例内部类的成分特点：
 *          实例内部类中不能定义静态成员 ，其他都可以定义     原因是：实例内部类属于外部类对象，随着外部类对象加载
 *          可以定义常量public static final
 *      实例内部类的访问格式：
 *          外部类名称.内部类名称  //和静态内部类一样的方式访问常量
 *      创建对象的格式：
 *          外部类名称.内部类名称  对象名称 =new 外部类构造器.new 内部类构造器;
 *
 *
 *         实例内部类可以访问外部类的静态成员和实例成员【都可以】
 *
 *
 *         相比较于静态内部类，实例内部类
 *              成分不同；创建对象方式不同；访问外部类成员不同
 */
public class InstanceInnerClass {

    public static void main(String[] args) {
        //实例内部类的访问格式
        System.out.println(Outer01.Inner01.PI);

        Outer01.Inner01 goldstine = new Outer01().new Inner01("goldstine", 14);//创建对象方式
        goldstine.show();
        System.out.println(goldstine.getName()+"="+goldstine.getAge());
    }

}

class Outer01{

    //实例内部类访问外部类静态成员
    public static int count=12;
    //实例内部类访问外部类实例成员变量
    public int count1=13;

    //成员内部类，唯一缺少的类成分是静态成员
    public class Inner01{
//        public static String name="goldstine";//成员内部类不能定义静态成员
        public static final double PI=3.14;   //但是可以通过static定义常量

        private String name;
        private int age;

        //实力内部类访问外部类静态成员
        public void show(){
            System.out.println(count);//实例内部类也是共享外部类静态成员
            System.out.println(count1);//实例内部类也可以访问外部类的实例成员，都是属于外部类对象
        }


        public Inner01(String name, int age) {
            this.name = name;
            this.age = age;
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
