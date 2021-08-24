package org.goldstine.Annotation;

import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 注解的解析
 * 我们可以使用一个注解注释一个类的成分，那么就涉及到要解析出这些注解的数据
 * 开发中经常要知道一个类的成分上面到底有哪些注解，注解有哪些属性数据，这都需要进行注解的解析
 * 与注解解析相关的接口：
 *      Annotation:注解类型，该类是所有注解的父类，注解都是一个Annotation的对象
 *      AnnotatedElement:该接口定义了与注解解析相关的方法
 *          所有的类成分Class  Method   Field   Constructor都实现了AnnotatedElement接口
 *          他们都拥有解析注解的能力
 *          （1）Annotation[] getDeclaredAnnotations()
 *                  获得当前对象上使用的所有注解，返回注解数组
 *           （2）T getDeclaredAnnotation(Class<T> annotationClass)
 *           根据注解类型获得对应的注解对象
 *           （3）boolean isAnnotationPresent(Class<Annotation> annotationClass)
 *           判断当前对象是否使用了指定类型的注解，如果使用了返回true,否则返回false
 *
 *           解析注解数据的原理：
 *              注解在那个成份上，我们就先拿那个成分对象
 *
 */
public class AnnotationEX {
    public static void main(String[] args) {
        //获取对应注解上的数据
        //1、首先获取对应的类上的注解信息
        Class clazz = BookStore.class;
        if(clazz.isAnnotationPresent(Book01.class)) {
            //通过字节码对象获得对应的类注解
            Book01 book = (Book01)clazz.getDeclaredAnnotation(Book01.class);//返回对应的注解对象
            System.out.println(book.value());
            System.out.println(book.price());
            String[] authors = book.authors();
            for (int i = 0; i < authors.length; i++) {
                System.out.println(authors[i]);
            }
        }
        //获得方法上的注解
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.isAnnotationPresent(Book01.class)){
                Book01 bk = declaredMethod.getDeclaredAnnotation(Book01.class);

                System.out.println(bk.value());
                System.out.println(bk.price());
                System.out.println(Arrays.toString(bk.authors()));

            }
        }

    }
}

//定义类
@Book01(value="goldstine",price = 102,authors = {"liulei","goldstine"})
class BookStore{
    @Book01(value="<Mybatis持久层框架>",price = 234.2,authors = {"金庸","古龙"})
    public void run(){

    }
}

//自定义一个注解
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Book01{
    String value();
    double price() default 100;
    String[] authors();

}