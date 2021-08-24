package org.goldstine;

/**
 * 异常：
 *异常是在程序编译或者执行的过程中可能出现的问题
 *  一场应该是尽量提前避免的
 *  异常可能也是无法做到绝对避免的，一场一旦出现，如果提前没有提前处理，程序就会退出jvm虚拟机而终止，开发中异常时需要提前处理的
 *
 * 编译时异常：
 * 继承自Exception的一场或其子类，编译阶段就会报错
 * 必须程序员处理，否则代码编译就不能通过
 * 运行时异常：
 * 继承自RuntimeException的异常或者其子类，编译阶段是不会报错的，它是在运行阶段可能出现，运行时异常可以处理也可以不处理，编译阶段是不会出错的
 * 但试运行阶段可能出现，还是建议提前处理
 *
 *
 * 常见的运行时异常：
 *      （1）数组索引越界异常：ArrayIndexOutOfBoundsException
 *     (2)空指针异常： NullPointException
 *     (3)类型转换异常（一般出现在泛型）ClassCastException
 *     (4)迭代器遍历没有此元素异常：NoSuchElementException
 *     (5)数学操作异常：ArithmeticException
 *     (6)数字转换异常：NumberFormatException
 *
 *编译时异常：继承自Exception的异常或者其子类，没有继承RuntimeException
 *
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("程序开始=====");
        //数组越界异常
//        int[] arrs={10,20,30,40,50};
//        for (int i = 0; i < 6; i++) {
//            System.out.println(arrs[i]);
//        }

        //空指针异常
        String name=null;
        System.out.println(name);
//        System.out.println(name.length());

        //类型转换异常
        Object o="我是中国人";
//        String o1 = (String) o;
//        int o1 = (int) o;
//        System.out.println(o1);

        //数学操作异常
//        System.out.println(10/0);

        //数字转换异常
        String num="23aa";
        Integer it = Integer.valueOf(num);
        System.out.println(it+1);

        System.out.println("程序结束");
    }
}
