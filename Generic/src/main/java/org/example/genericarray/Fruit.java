package org.example.genericarray;

import java.lang.reflect.Array;

public class Fruit<T> {
//    private T[] array=new T[3];//连T的类型都不知道，更加不可能用来创建数组对象
    //只声明对应的成员
    private T[] array;

    public Fruit(Class<T> clz,int length){
        //通过Array.newInstance()创建泛型数组
        array=(T[]) Array.newInstance(clz,length);
    }

    //往数组中放入一条数据
    public void put(int index,T item){
        array[index]=item;
    }

    //获取数组中的一个元素
    public T get(int index){
        return array[index];
    }

    //获取数组中的所有元素
    public T[] getArray(){
        return array;
    }
}
