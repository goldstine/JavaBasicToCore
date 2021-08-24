package org.goldstine.Annotation;

/**
 * 自定义注解：
 *      格式：
 *      [修饰符] @interface 注解名{
 *          //注解属性
 *      }
 *
 *      小结：自定义注解使用@interface关键字
 *          注解默认可以标记很多地方
 *
 *      注解的属性格式：
 *          属性的格式
 *              格式1：数据类型 属性名();
 *              格式2：数据类型 属性名() default 默认值;
 *
 *      属性适用的数据类型：
 *          八种数据类型int,short,long,double,byte,char,boolean,float
 *          String,Class以上类型的数组形式都支持
 *
 *
 *      小结：注解可以有属性，属性名必须带()
 *      再用注解的时候，属性必须赋值，除非这个属性有默认值
 *
 * 注解的特殊属性名称：value
 * value属性，如果只有一个value属性的情况下，使用value属性的时候可以省略value名称不写
 *
 *
 */
@Book(name="<精通java基础>",authors = {"goldstine","liulei"},price = 12.3)
@MyTest("/deleteBook.action")//对于value属性，如果只有一个值，可以省略对应的value属性名
@MyBook(value = "goldstine",number = 13)
public class DefineAnnotation {
    @MyTest(value = "/deleteBook.action")
    private String name;

    @MyTest(value = "/deleteBook.action")
    public DefineAnnotation(){

    }
    @Book(name="<精通java基础>",authors = {"goldstine","liulei"},price = 12.3)
    @MyTest(value = "/deleteBook.action")
    public static void main(@MyTest(value = "/deleteBook.action") String[] args) {

        //标记局部变量
        @MyTest(value = "/deleteBook.action")
        int age=12;
    }
}

@interface Book{
    public String name();//默认的修饰符就是public
    String[] authors();//数组
    double price();
    String address() default "广州";

}
@interface MyTest{
    String value();
}

@interface MyBook{
    String value();
    int number();
//    int price() default 10;//如果另一个字段有默认值，可以省略对应的value=
}