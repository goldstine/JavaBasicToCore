package org.example.genericextendssuper;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 下限通配符在jdk中的使用   TreeSet集合的构造方法穿一个比较器的使用
 */
public class Test01 {
    public static void main(String[] args) {
//        TreeSet<Cat> treeSet=new TreeSet<>(new Comparator2());//TreeSet的构造方法存在一个下限通配符super
        //既然是一个下限通配符，能否传一个比较animal的接口
        TreeSet<Cat> treeSet = new TreeSet<>(new Comparator1());
//        TreeSet<Cat> treeSet = new TreeSet<>(new Comparator3());//报错
        treeSet.add(new Cat("jerry",12));
        treeSet.add(new Cat("tom",67));
        treeSet.add(new Cat("jim",123));
        treeSet.add(new Cat("bob",43));
        for (Cat cat : treeSet) {
            System.out.println(cat.age+" : "+cat.name);
        }
    }
}

class Comparator1 implements Comparator<Animal> {

    @Override
    public int compare(Animal o1,Animal o2) {
        return o1.name.compareTo(o2.name);
    }
}
class Comparator2 implements Comparator<Cat>{

    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age-o2.age;
    }
}
class Comparator3 implements  Comparator<MiniCat>{

    @Override
    public int compare(MiniCat o1, MiniCat o2) {
        return o1.level-o2.level;
    }
}