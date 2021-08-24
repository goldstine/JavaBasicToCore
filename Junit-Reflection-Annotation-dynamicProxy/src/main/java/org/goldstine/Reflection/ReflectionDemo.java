package org.goldstine.Reflection;

/**
 * 反射的概念：
 * 反射，注解，代理，泛型是java的高级技术
 * 反射是java独有的技术，是java技术显著的特点
 *
 * 反射是指对于任何一个类，在“运行时时候”都可以直接得到这个类的全部成分
 *      在运行时，可以直接得到这个类的构造器对象（Constructor）
 *      在运行时，可以直接得到这个类的成员变量对象（Field）
 *      在运行时，可以直接得到这个类的成员方法对象（Method）
 *
 *      反射核心思想和关键就i是得到：编译之后的class文件对象
 *
 *      反射提供了一个lass类型，就是可以得到编译之后的class类对象
 *
 *      HelloWorld.java--->javac--->HelloWorld.class
 *      class c=HelloWorld.class
 *
 * Class:字节码文件的类型
 * Constructor:构造器类型
 * Field:成员变量的类型
 * Method:方法的类型
 *
 * 对应的class字节码文件对象，对应的方法有：
 *      getSimpleName()
 *
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //反射的第一步永远是先得到类的class文件对象：字节码文件
        //1、类名.class
        Class<?> studentClass = Student.class; //直接通过对应的文件Student.class返回一个Class类型的对象
        //一般不会直接写Class<>泛型，因为更多情况下并不知道对应的字节码文件的类型
        //但是直接可以写一个通配符？泛型 Class<?> studentClass=Student.class
        System.out.println(studentClass.toString());

        //2、对象.getClass()
        //通过对象获取对应的字节码文件class类型
//        Student student = new Student();
//        Class<? extends Student> aClass = student.getClass();
//        System.out.println(aClass);

        //3、Class.forName("类的全限名")
        //直接去加载该类的Class文件       public static Class<?> forName(String className)
        Class<?> aClass1 = Class.forName("org.goldstine.Reflection.Student");
        System.out.println(aClass1);
        //通过底层的类加载器Class,将对应的java文件进行编译程字节码文件，然后加载到内存中


        //getSimpleName()；获得对应的简名
        System.out.println(studentClass.getSimpleName());//Student.经常使用，直接获得对应的类名
        //getName();获得类的全限名
        System.out.println(studentClass.getName());//org.goldstine.Reflection.Student

        //通过字节码文件对象创建对象
        Student s1 = (Student)studentClass.newInstance();//调用无参构造器得到对象，被淘汰了，不建议使用
        //建议通过构造器对象获取对象，不建议通过字节码文件获取对象




    }
}
