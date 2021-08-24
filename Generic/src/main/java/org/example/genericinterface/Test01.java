package org.example.genericinterface;

public class Test01 {
    public static void main(String[] args) {
        Apple apple = new Apple();//接口的实现类Apple不是一个泛型类
        String key = apple.getKey();
        System.out.println(key);
        System.out.println("=========================");
        Pair<String,Integer> pair=new Pair<>(12,"goldstine");//实现类写了带参数的构造方法，就会将无参构造器覆盖
        String key1 = pair.getKey();
        System.out.println(key1);
    }
}
