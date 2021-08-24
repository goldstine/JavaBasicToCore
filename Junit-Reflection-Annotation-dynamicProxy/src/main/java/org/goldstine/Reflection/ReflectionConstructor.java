package org.goldstine.Reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 获取Constructor构造器对象
 * 反射中Class类型获取构造器提供了很多api
 * （1）Constructor getConstructor(Class... parameterTypes)
 * 根据参数匹配获取某个构造器，只能拿public修饰的构造器，几乎不用
 * （2）Constructor getDeclaredConstructor(Class... parameterTypes)
 * 根据参数匹配获取某个构造器，只要声明就可以定位，不关心权限修饰符。建议使用
 * （3）Constructor[] getConstructors()
 * 获取所有的构造器，只能拿public 修饰的构造器，几乎不用，太弱了
 * （4）Constructor[] getDeclaredConstructors()
 * 获取所有声明的构造器，只要你写我就能拿到，无所谓权限，建议使用
 *
 * 小结：
 *  获取类的全部构造器对象：Constructor[] getDeclaredConstructors()
 *
 *
 * 对应的构造器对象有对应的方法：
 *      getName()获得对应的构造器的名字
 *      getParameterCount();获得构造器的参数个数
 *
 */
public class ReflectionConstructor {
    public static void main(String[] args) throws NoSuchMethodException {
        //getConstructors();获取全部构造器，只能获取public 修饰的构造器
        //（1）首先得到对应的class对象
        Class<?> clazz=Student.class;
        //获取所有的public构造器
//        Constructor<?>[] constructors = clazz.getConstructors();

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        //直接输出对应的数组
//        System.out.println(Arrays.toString(constructors));
        //遍历所有的构造器
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName()+"========>"+constructor.getParameterCount());
        }


        //获取一个构造器，根据参数的个数进行匹配
//        Constructor<?> constructor = clazz.getConstructor();//报错，不能拿到私有无参构造器
//        System.out.println(constructor.getName()+"=====>"+constructor.getParameterCount());

        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        //可以获取对应的有参public构造器
        System.out.println(declaredConstructor.getName()+"======>"+declaredConstructor.getParameterCount());

        //通过getDeclaredConstructor()获得对应的无参私有构造器
        Constructor<?> declaredConstructor1 = clazz.getDeclaredConstructor();
        System.out.println(declaredConstructor1.getName()+"=====>"+declaredConstructor1.getParameterCount());

    }
}
