package org.goldstine.lambda.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;

/**
 * 方法引用的四种形式：
 *      （1）静态方法的引用
 *      （2）实例方法的引用
 *      （3）特定类型方法的引用
 *      （4）构造器的引用
 *
 *      静态方法的引用
 *              应用格式：类名::静态方法
 *            简化格式：
 *              定义一个静态方法，把需要简化的代码放到一个静态方法中去
 *
 *          注意：
 *              被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致
 *              如果函数式接口中的抽象方法有返回值，则被引用的方法必须也有相同的返回值
 *              如果函数式接口中的抽象方法没有返回值，则被引用的方法可以有返回值，也可以没有返回值
 *      实例方法引用：
 *              格式：对象::实例方法
 *              简化步骤：
 *                  定义一个实例方法，把需要的代码放到实例方法中去
 *              实例方法的注意事项
 *                  被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致
 *
 *
 *       特定类型方法的引用：
 *              格式：特定类型::方法
 *          注意：如果第一个参数列表中的形参中的第一个参数作为了后面的方法的调用者
 *              并且其余参数作为后面方法的形参，那么就可以用特定类型方法引用了
 *
 *
 *      构造器引用：
 *          格式：类名::new
 *           注意：前后参数已知的情况下，又在创建对象就可以使用构造器引用
 *              s->new Student(s)  ===>   Student::new
 *
 *
 */
public class MethodDemo02 {
    public static void main(String[] args) {
        String[] strs=new String[]{
                "James","AA","John","Patricia","Dlei","Robert","Boom","Cao","black","Michael","Linda","cao","after","sBBB"
        };
        //需求：按照元素的首字母（忽略大小写）升序排序
//        Arrays.sort(strs,new Comparator<String>(){
//
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);//忽略大小写比较
//            }
//        });
        /**
         * 这里首先要注意的是：数组可以接口进行排序，字符串提供忽略大小写进行比较的方法 compareToIgnoreCase()
         */
        //简化的方式
//        Arrays.sort(strs,( o1,  o2) -> o1.compareToIgnoreCase(o2));
        //由于compareToIgnoreCase()是sun公司定义的特定方法引用的简化
        //该方法作为特定类型String的方法
        //简化的方式就是将所有参数去掉
        Arrays.sort(strs,String::compareToIgnoreCase);

        System.out.println(Arrays.toString(strs));


        //构造器引用
        List<String> lists=new ArrayList<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");
        //集合默认只能转成Object类型数组
        Object[] objects = lists.toArray();
        System.out.println("Object类型的数组："+Arrays.toString(objects));

        //如果要转换成字符串类型数组

        //最新的写法可以结合构造器引用实现
//        String[] str = lists.toArray(new IntFunction<String[]>() {
//
//            @Override
//            public String[] apply(int value) {
//                return new String[value];
//            }
//        });
//构造器引用简化
//        String[] str = lists.toArray( value -> new String[value]);
        //前后参数一样，并且用于创建对象
//        String[] str = lists.toArray( String[]::new);
    }

}
