package org.goldstine;

/**
 * 使用自定义异常
 *     根据实际情况进行自定义异常====取决于具体的业务
 */
public class ExceptionDefinitionTest {
    public static void main(String[] args) {
        try {
            checkAge(1000);
        } catch (ExceptionDefinition exceptionDefinition) {
            exceptionDefinition.printStackTrace();
        }
    }

    private static void checkAge(int age) throws ExceptionDefinition {
        if(age<0||age>200){
            throw new ExceptionDefinition("/ age is illegal!");//这个是编译时异常，该异常对象还需要继续抛

        }else{
            System.out.println("年龄是："+age);
        }
    }
}
