package org.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * 创建一个泛型类
 * 泛型使用
 */
public class ProductGetter<T> {
    //奖品
    private T product;

   static Random random=new Random();
    //奖品池
    ArrayList<T> list=new ArrayList<T>();

    public void addProduct(T t){
        list.add(t);
    }

    public  T getProduct(){  //这个不是泛型方法，只是使用了泛型类的泛型标识的实例方法
        product= list.get(random.nextInt(list.size()));
        return product;
    }

    //定义一个泛型方法

    /**
     *
     * @param list  参数
     * @param <E>  泛型标识，具体类型，由调用方法的时候来指定
     * @return
     */
    public  <E> E getProduct01(ArrayList<E> list){
        return list.get(random.nextInt(list.size()));
    }

    //定义一个静态泛型方法
    public static <E,T,K> void get(E e,T t,K k){
        System.out.println(e.getClass().getSimpleName());
        System.out.println(t.getClass().getSimpleName());
        System.out.println(k.getClass().getSimpleName());
    }

    //定义一个可变参数静态泛型方法
    public static <E> void print(E... e){
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }

}
