package org.goldstine.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解：
 * 元注解是sun公司提供的
 * 元注解使用在自定义注解上的注解
 * 元注解是用来注解自定义主机的
 *
 * 元注解有两个：
 * @Target:约束自定义注解只能在在哪些地方使用    但是默认的注解可以在类，方法，构造器，成员变量使用
 * @Retention:生命注解的生命周期
 *      声明注解的作用范围；编译时，运行时
 *
 * @Target可以使用的值定义在ElementType没聚类中。常用的值如下所示：
 * TYPE：类，接口
 * FIELD:成员变量
 * METHOD：成员方法
 * PARAMETER:方法参数
 * CONSTRUCTOR:构造器
 * lOCAL_VARIABLE局部变量
 *
 * @Retention
 * 可以使用的值定义在枚举类RetentionPolicy没聚类中，常用值如下所示：
 *  SOURCE:注解只作用在源码阶段，生成的字节码文件中不存在
 *  CLASS:注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值
 *  RUNTIME:注解作用在源码阶段，字节码文件阶段，运行阶段  【开发常用】
 *
 *
 */

public class MetaAnnotation {
    @stine
    public static void main(String[] args) {

    }
}

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface stine{

}