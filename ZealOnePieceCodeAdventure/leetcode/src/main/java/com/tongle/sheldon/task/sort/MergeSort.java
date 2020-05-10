package com.tongle.sheldon.task.sort;

/**
 * 归并排序算法
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,1,0};

        mergeSort(arr,0,5);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print("\t");
        }

    }

    /**
     * 归并排序 递归实现
     * @param arr
     * @param left
     * @param right
     */
    private static void mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid = (left + right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    /**
     * 进行归并
     * @param arr
     * @param left
     * @param right
     */
    private static void merge(int[] arr,int left,int mid,int right){
        //需要一个辅助空间 copy数组 临时数组
        int[] tmp = new int[right -left + 1];
        for(int i=left;i<=right;i++){
            //arr数组下标是从left开始的 而tmp下标是从0开始的
            tmp[i-left] =arr[i];
        }
        //开始归并
        //准备两个数组的起始索引
        int i= left;
        int j = mid + 1;
        for(int k=left;k<=right;k++){
            if(i>mid){//左边的数组遍历完
                arr[k] = tmp[j-left];
                j++;
            }else if (j>right){//右边的数组遍历完毕
                arr[k] = tmp[i-left];
                i++;
            } else if (tmp[i-left]<tmp[j-left]){
                //注意copy的是全数组，所以下标是要-left的
                arr[k] = tmp[i-left];
                i++;
            }else if (tmp[i-left]>tmp[j-left]){
                arr[k] = tmp[j-left];
                j++;
            }
        }
    }


}
