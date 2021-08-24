package org.example.genericarray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 反省和数组对象的初始化本身就是冲突的，所以不能创建带泛型的数组对象
 */
public class Test01 {
    public static void main(String[] args) {
//        ArrayList[] list = new ArrayList[5];
//        ArrayList<String>[] listArr=list;
        //解决的方式就是不讲原生数组的引用暴露出去
        ArrayList<String>[] listArr=new ArrayList[5];

        ArrayList<Integer> intList=new ArrayList<>();
        intList.add(100);

        //此时如果直接给listArr填充元素会直接进行类型检查
//        listArr[0]=intList;//直接报错进行类型检查
//        list[0]=intList;

        //此时直接检查，必须创建一个String类型的ArrayList
        ArrayList<String> stringArrayList=new ArrayList<>();
        stringArrayList.add("goldstine");
        stringArrayList.add("liulei");
        listArr[0]=stringArrayList;

        String s = listArr[0].get(0);
        System.out.println(s);


        System.out.println("+++++++++++++++++++++++测试通过Array.newInstance()方式创建泛型数组+++++++++++++++++++++");

        //Class<T> cls =====>String.class 表示字节码文件

        Fruit<String> stringFruit = new Fruit<>(String.class, 3);//注意这里stringFurit是一个数组

        stringFruit.put(0,"苹果");
        stringFruit.put(1,"香蕉");
        stringFruit.put(2,"葡萄");

        String[] array = stringFruit.getArray();
        //通过Array的toString()转为固定格式

        System.out.println(Arrays.toString(array));

        String s1 = stringFruit.get(2);
        System.out.println(s1);
    }
}
