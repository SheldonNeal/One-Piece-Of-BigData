package com.tongle.sheldon.task.sort;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr ={3,5,1,6,7,43,9};
//        quickSort2Ways(arr,0,6);
//        quickSort3ways(arr,0,6);
        System.out.println(topK(arr,0,6,1));
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }

    /**
     * 三路快排 借助于单路快排的优化
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort3ways(int[] arr,int left,int right){
        //[left+1..lt]<v [gt,right]>v  [lt+1,i)=v
        int privot = arr[left];
        int lt = left ;
        int gt=right + 1;

        int i=left + 1;
        while (i<gt){
            if(arr[i]<privot){
                swap(arr,lt+1,i);
                lt++;
                i++;
            }else if(arr[i]>privot){
                swap(arr,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        arr[left] = arr[lt];
        arr[lt] = privot;
        quickSort3ways(arr,left,lt-1);
        quickSort3ways(arr,gt,right);

    }

    /**
     * 双路快速排序
     */
    private static void quickSort2Ways(int[] arr,int left,int right){
        if(left>right){
            return;
        }
        int i=left,j=right;
        int privot = arr[left];
        while (i!=j){
            //顺序很重要，先从右往左找
            while (arr[j]>=privot && i<j){
                j--;
            }
            while (arr[i]<=privot && i<j){
                i++;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        arr[left] = arr[i];
        arr[i] = privot;

        quickSort2Ways(arr,left,i-1);
        quickSort2Ways(arr,i+1,right);
    }

    /**
     * 双路快速排序
     */
    private static int topK(int[] arr,int left,int right,int k){
        if(left>right){
            return -1;
        }
        int i=left,j=right;
        int privot = arr[left];
        while (i!=j){
            //顺序很重要，先从右往左找
            while (arr[j]<=privot && i<j){
                j--;
            }
            while (arr[i]>=privot && i<j){
                i++;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        arr[left] = arr[i];
        arr[i] = privot;

        if(i==k-1){
            return privot;
        }
        if(i<k-1){
            return topK(arr,i+1,right,k);
        }

        return topK(arr,left,i-1,k);


    }

    /**
     * 交换数组中元素的位置
     * @param arr
     * @param left
     * @param right
     */
    private static void swap(int[] arr,int left,int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
