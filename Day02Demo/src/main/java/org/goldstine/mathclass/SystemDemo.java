package org.goldstine.mathclass;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * 系统类
 * System代表当前系统
 * 静态方法：
 *      public static void exit(int status):终止jvm虚拟机，非0是异常终止
 *      public static long currentTimeMillis();获取当前系统此刻时间毫秒值
 *      可以做数组拷贝
 *          arraycopy(Object var0,int var1,Object var2,int var3,int var4);
 *              参数一：原数组
 *              参数二：从原数组的哪个位置开始赋值
 *              参数三：目标数组
 *              参数四：赋值到目标数组的哪个位置
 *              参数五：赋值几个
 *
 *
 */
public class SystemDemo {

    public static void main(String[] args) {
        System.out.println("开始....");
//        System.exit(0);//0表示正常终止

        //可以通过System直接获取时间毫秒值
        long l = System.currentTimeMillis();
        System.out.println(l);
        //格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = sdf.format(l);
        System.out.println(format);

        //数组拷贝
        int[] arr1=new int[]{10,20,30,40,50,60,70};
        int[] arr2=new int[6]; //[0,0,0,0,0,0]
        //arr2=[0,30,40,50,0,0]
        /**
         *  public static native void arraycopy(Object src,  int  srcPos,
         *                                         Object dest, int destPos,
         *                                         int length);
         */
        System.arraycopy(arr1,2,arr2,1,3);
//        System.out.println(arr2.toString());//数组输出只能看到位置
        System.out.println(Arrays.toString(arr2));

        System.out.println("结束");
    }

}
