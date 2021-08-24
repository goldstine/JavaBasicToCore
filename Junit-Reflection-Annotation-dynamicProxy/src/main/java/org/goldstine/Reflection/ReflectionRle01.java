package org.goldstine.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射拓展：反射破坏封装性和泛型的约束性
 * 反射破坏封装性（暴力反射）
 * 反射破坏约束性（泛型擦除）
 */
public class ReflectionRle01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //反省工作在编译阶段，运行阶段泛型就消失了
        //反射工作在运行阶段
        List<Double> scores=new ArrayList<>();
        scores.add(99.3);
        scores.add(199.3);
        scores.add(89.5);

        //通过反射暴力地注入一个其他类型的数据进去
        //先得到集合对象的class文件对象
        Class<? extends List> c = scores.getClass();//由于实际的对象是ArrayList,所以获取的是ArrayList的字节码文件对象

        //从ArrayList的Class对象中定位add方法
        Method add = c.getMethod("add", Object.class);//由于add()方法可以添加一切类型，所以对应的参数类型为Object.class

        //触发scores集合对象的add执行（运行阶段，泛型不能进行约束了）
        add.invoke(scores,"goldstine");

        //
        System.out.println(scores);//[99.3, 199.3, 89.5, goldstine]  暴力加入一个其他类型的数据
        //所有的约束对于反射都是形同虚设
    }
}
