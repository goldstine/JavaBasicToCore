package org.goldstine;

/**
 * 自定义异常：
 *  需求：认为年龄小于0岁，大于200岁就是一个异常
 *  自定义异常：
 *  （1）自定义编译时异常
 *      定义一个异常类继承Exception
 *      重写构造器
 *      再出现异常的地方抛出自定义异常类的对象：throw new 自定义对象抛出
 *      编译时异常是编译阶段就报错，提醒更加强烈，一定需要处理
 *
 *  （2）自定义运行时异常
 *      定义一个异常类继承RuntimeException
 *      重写构造器
 *      再出现异常的地方用throw new 自定义异常类对象抛出
 *      提醒不强烈，编译阶段不报错
 *
 *
 */
public class ExceptionDefinition extends Exception{
    public ExceptionDefinition() {
    }

    public ExceptionDefinition(String message) {
        super(message);
    }

    public ExceptionDefinition(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionDefinition(Throwable cause) {
        super(cause);
    }

    public ExceptionDefinition(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static void main(String[] args) {

    }


}
