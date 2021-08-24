package org.goldstine.objectclass;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private char sex;

    public Student() {
    }

    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    //重写equals

    @Override
    public boolean equals(Object o) {
        //1、判断是否自己和自己比较，如果是同一个对象比较直接返回true
        if (this == o) return true;
        //1、判断被比较这是否为null，以及是否为学生类型
        if (o == null || getClass() != o.getClass()) return false;
        //1、o一定是学生类型，强制转换为学生，开始比较内容
        Student student = (Student) o;
        return age == student.age &&
                sex == student.sex &&
                Objects.equals(name, student.name);
        //通过Objects的equals比较更安全
    }

    /**
     * student.equals(student1)
     *比较者：student ===this
     * 被比较者：   student1===obj
     * @param o
     * @return
     */

//    @Override
//    public boolean equals(Object o) {
//       //首先判断是否是学生类型
//        if(o instanceof Student){
//            //字符串有自己的equals方法，字符串类重写了equals()比较字符串，但是现在这里是定义比较两个对象，重写equals
//            //强制类型转换
//            Student o1 = (Student) o;
//            //基本数据类型通过==比较
//            if(this.name.equals(o1.name)&& this.age==o1.age&&this.sex==o1.sex){
//                return true;
//            }else{
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}
