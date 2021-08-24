package org.goldstine.Reflection;

public class Dog {
    private String name;
    private int age;
    private String color;
    public static String school;
    public static final String SCHOOL_1="宠物学校";

    public Dog() {
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Dog.school = school;
    }

    public static String getSchool1() {
        return SCHOOL_1;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
