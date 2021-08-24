package org.goldstine.Reflection.application;

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        Student student = new Student(1, "赵敏", 26, '女', "光明顶", "110");
        Mybatis.save(student);//由于save方法抛出了异常，所以对应的调用save()也会抛出异常

        Pig pig = new Pig("乔治", 500.0, "粉色", "小红", "母猪");
        Mybatis.save(pig);




    }
}
