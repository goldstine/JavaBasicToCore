package org.goldstine.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        //通过冒泡排序
        int[] arr=new int[]{55,22,99,88};
//        bubbleSort(arr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] a){
        //冒泡排序需要机进行n-1轮排序
        for (int i = 0; i < a.length-1; i++) {
            //每一轮排序需要进行a.length-1-i次比较
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    //进行交换
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }

    //选择排序

    /**
     * 选择排序，每次从当前位置开始找出后面的较小值与该位置交换
     * @param a
     */
    public static void selectSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for(int j=i+1;j<=a.length-1;j++){
                if(a[i]>a[j]){
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
    }



}
