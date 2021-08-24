package org.goldstine.algorithm;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        //需求：找出81号元素的索引值，利用二分查找
        int[] arr={10,14,21,38,45,47,53,81,87,99};

        int index = binarySearch(arr,81);

        System.out.println(index);

    }

    public static int binarySearch(int[] a,int val){
        //通过二分查找
        int left=0;
        int right=a.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(a[mid]<val){
                left=mid+1;
            }else if(a[mid]>val){
                right=mid-1;
            }else if(a[mid]==val){
                return mid;
            }
        }

        return -1;
    }
}
