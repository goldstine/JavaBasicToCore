package org.goldstine.innerclass;

/**
 * 测试局部内部类
 * 定义在方法中，构造器中，代码块中，for循环中定义的内部类
 *
 * 局部内部类的成分：
 *      只能定义实例成员，不能定义静态成员，可以定义常量
 *
 *     小结：没啥用
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        class A{
            //局部内部类不能定义静态成员
//            public static String name="liulei";
            //但是可以定义常量
            public static final double PI=3.14;

            public  void test(){
                System.out.println("goldstine");
            }
        }
        //创建局部内部类的对象
        A a = new A();
        a.test();

    }

    public void test(){
        class Animal{

        }
        class Cat extends Animal{

        }
    }
}
