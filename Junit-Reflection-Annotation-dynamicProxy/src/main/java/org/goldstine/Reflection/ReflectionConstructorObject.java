package org.goldstine.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *  反射获取对应的构造器之后，通过该构造器可以初始化对象
 *  初始化并得到类的一个对象返回
 *
 *  Constructor的api:
 *          （1）T newInstance(Object... initargs);  创建对象，注入构造器需要的数据
 *          （2）void setAccessible(true)
 *              修改访问权限，true代表暴力攻破权限，false表示保留不可访问权限（暴力反射）
 *
 *           小结：可以通过定位类的构造器对象
 *           如果构造器对象没有访问权限可以通过，void setAccessible(true)打开权限
 *           构造器可以通过T newInstance(Object... initargs）调用自己，传入参数
 *
 *之所以称之为反射：
 *      以前是通过构造器new一个对象
 *      现在是通过构造器.new自己，所以称之为反射
 *
 */
public class ReflectionConstructorObject {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        //调用无参构造器初始化一个类的对象并返回
        Class<?> clazz = Student.class;

        //通过class对象获取对应的构造器对象
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);

        //通过构造器初始化一个对象
        Student student =(Student) declaredConstructor.newInstance("goldstine", 12);

        //输出对象
        System.out.println(student);

        //通过私有化的无参构造器初始化对象
        //首先通过clazz获取对应的无参构造器
        Constructor<?> declaredConstructor1 = clazz.getDeclaredConstructor();

        //首先要将私有构造器的权限修改，暴力反射
        declaredConstructor1.setAccessible(true);//一次性有效，只能在当前位置打开权限，其他位置还需要继续打开

        //通过私有化的无参构造器初始化对象
        Student stu =(Student) declaredConstructor1.newInstance();

        System.out.println(stu);
    }
}
