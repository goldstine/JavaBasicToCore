package org.example.genericdiv;

import java.util.List;

public class Erasure<T extends Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }


    //定义一个泛型方法进行上限泛型擦除
    public  <T extends List> T show(T t){
        System.out.println("泛型方法的上线类型擦除");
        return t;
    }

}
