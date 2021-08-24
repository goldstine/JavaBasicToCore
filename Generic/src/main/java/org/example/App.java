package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String[] args) {
        ProductGetter<String> objectProductGetter = new ProductGetter<>();
        String[] strProducts={"苹果手机","华为手机","扫地机器人","咖啡机"};
        for (int i = 0; i < strProducts.length; i++) {
            objectProductGetter.addProduct(strProducts[i]);
        }

        String product = objectProductGetter.getProduct();
        System.out.println("恭喜您，抽中了："+product);


        //泛型的可扩展性，直接抽取奖金Double

        ProductGetter<Double> doubleProductGetter=new ProductGetter<>();
        Double[] sa={12.2,23.4,56.7,78.8};
        for (int i = 0; i < sa.length; i++) {
            doubleProductGetter.addProduct(sa[i]);
        }
        //抽奖
        Double product1 = doubleProductGetter.getProduct();
        System.out.println("恭喜您，抽中了:"+product1);


        System.out.println("测试泛型方法");

        //测试ProductGetter中定义的泛型方法
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(8);
        Integer product01 = stringProductGetter.getProduct01(list);

        System.out.println(product01);


        //测试静态泛型方法
        ProductGetter.get(100,"java",true);


        //测试可变参数的静态泛型方法
        ProductGetter.print(1,2,3,4,5);
        ProductGetter.print('a','b','c');
    }

    public static void main0( String[] args )
    {
//        ArrayList list = new ArrayList();
//        list.add("java");
//        list.add(100);
//        list.add(true);
//
//        for (int i = 0; i < list.size(); i++) {
//            Object o = list.get(i);
//            String s = (String) o;
//            System.out.println(s);
//        }


        ArrayList<String> strings = new ArrayList<>();
        strings.add("goldstine");
//        strings.add(1);//报错，编译时检查安全

        Generic<String> stringGeneric = new Generic<>("Goldstine");
        System.out.println(stringGeneric.getKey());


        Generic generic = new Generic(1);
        generic.setKey(12);
        Object key = generic.getKey();//泛型类在创建对象的时候，如果没有指定类型，将按照Object类型来操作
        System.out.println(generic.getKey());

//        Generic<int> generic1 = new Generic<int>(12);
        Generic<Integer> integerGeneric = new Generic<Integer>(12);

        System.out.println(stringGeneric.getClass());
        System.out.println(stringGeneric.getClass()==integerGeneric.getClass());//同一泛型类，根据不同的数据类型创建的对象，本质上是同一类型



    }
}
