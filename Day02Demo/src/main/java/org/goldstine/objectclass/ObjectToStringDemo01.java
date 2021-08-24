package org.goldstine.objectclass;


/**
 * Object类的常用方法：
 *      （1）public String toString(){}
 *              默认是返回当前对象在堆内存中的地址信息
 *              默认的地址信息格式：类的全限名@内存地址  org.goldstine.objectclass.Student@1b6d3586
 *              直接输出对象名称，默认会自动调用toString()方法，所以输出对象toString()调用可以省略
 *              开发中直接输出对象，默认输出对象的地址其实无意义的
 *                  开发中输出对象变量，更多的时候是希望看到对象的内容数据而不是对象的地址信息
 *                  所以父类的toString()存在的意义就是被子类重写，一边输出对象内容信息
 *
 *
 *        (2)public boolean equals(Object o);
 *          默认比较两个对象的地址是否相同，
 *          直接比较两个对象的地址完全可以用“==”替代equals
 *              所以equals()存在的意义就是为了被子类重写，以便可以自己定义比较规则
 *
 *              自定义比较两个对象的内容
 */

public class ObjectToStringDemo01 {

    public String name1="liulei";
    public String name2="liulei";

    public static void main(String[] args) {
        Student student = new Student("liulei",12,'男');
        System.out.println(student.toString());
        System.out.println(student);//直接输出对象名称，默认会自动调用toString()方法，所以输出对象toString()调用可以省略


        Student student1 = new Student("liulei", 12, '男');

        System.out.println(student.equals(student1 ));

        System.out.println(student==student1);
    }

}
