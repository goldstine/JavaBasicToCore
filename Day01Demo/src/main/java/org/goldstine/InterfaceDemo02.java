package org.goldstine;

/**
 * 接口与接口之间的多继承
 * 引入：
 *          类与类之间是单继承关系，一个类只能继承一个直接父类
 *          类与接口之间是多实现关系，一个类可以同时实现多个接口
 *          接口与接口之间是多继承关系，一个接口可以同时继承多个接口    跟接口转接头一样
 */
public class InterfaceDemo02 {
}
//接口与接口之间的多继承，用一个接口合并多个接口
class Person implements SportMan01{

    @Override
    public void run() {

    }

    @Override
    public void competition() {

    }

    @Override
    public void rule() {

    }

    @Override
    public void abroad() {

    }
}

interface SportMan01 extends Law,Go{
    void run();
    void competition();
}

interface Law{
    void rule();
}

interface Go{
    void abroad();
}
