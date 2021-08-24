package org.goldstine;

import org.goldstine.RuntimeExceptionDefinition;

public class RuntimeExceptionDefinitionTest {
    //测试使用运行时异常
    public static void main(String[] args) throws RuntimeException{

        run();
    }
    public static void run(){
        throw new RuntimeExceptionDefinition("这是一个运行时异常");
        //运行时异常编译阶段不会报错，不要求将异常对象继续抛出去

        /**
         * 如果需要强烈提醒，则定义一个编译时异常
         * 如果不需要强烈提醒，可以定义为运行时异常
         */

    }
}
