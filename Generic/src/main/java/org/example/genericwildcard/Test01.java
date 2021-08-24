package org.example.genericwildcard;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public static void main(String[] args) {
        Box<Number> box1=new Box<>();
        box1.setFirst(100);
        showBox(box1);

        //Integer继承自Number
        Box<Integer> box2=new Box<>();
        box2.setFirst(200);
        showBox(box2);


        ArrayList<Animal> animals=new ArrayList<>();
        ArrayList<Cat> cats=new ArrayList<>();
        ArrayList<MiniCat> miniCats=new ArrayList<>();

        cats.addAll(cats);
        cats.addAll(miniCats);
//        ArrayList集合的方法addALL()的参数也是适用的上限通配符  表示只能使用E Cat类对象以及Cat子类类型

//        showAnimal(animals);
        showAnimal(cats);
        showAnimal(miniCats);


        showAnimal1(animals);
        showAnimal1(cats);
//        showAnimal1(miniCats);
    }


    //测试泛型通配符的下限    类型通配符要求集合只能是Cat或Cat的父类类型
    public static void showAnimal1(List<? super Cat> list){
        list.add(new Cat());
//        list.add(new Animal());
        list.add(new MiniCat());
        for(Object o : list){//所有的父类上显示Object,所以通过Object接收
            System.out.println(o);
        }
    }


    //测试泛型通配符的上限     类型通配符的list中不能够添加元素
    public static void showAnimal(ArrayList<? extends Cat> list){
//        list.add(new Cat());  //类型通配符中的list不能添加元素
        for (int i = 0; i < list.size(); i++) {
            Cat cat = list.get(i);
            System.out.println(cat);
        }
    }


    public static void showBox(Box<? extends Number> box){ //类型通配符的上限,表示上限就是Number类，表示只能传number类或者Number类的子类
        Number first = box.getFirst();
        System.out.println(first);
    }

//    public static void showBox(Box<?> box){
//        Object first = box.getFirst();
//        System.out.println(first);
//    }

//    public static void showBox(Box<Number> box){//泛型类型不能够通过多态的方式理解
//        Number first = box.getFirst();
//        System.out.println(first);
//    }

    //也不能够通过方法重载的方式,因为这两个方法的参数类类型相同，所以这两个方法很本就不是重载
//    public static void showBox(Box<Integer> box){
//        Number first = box.getFirst();
//        System.out.println(first);
//    }

}
