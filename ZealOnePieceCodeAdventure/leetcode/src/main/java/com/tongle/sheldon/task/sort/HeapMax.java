package com.tongle.sheldon.task.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 构建一个最大堆  一棵完全二叉树
 * 通过数组来构建一个堆
 *
 */
public class HeapMax {
    private int count;
    private int capacity;

    /**
     * 将元素逐个插入到空堆中 时间复杂度 O(nlogn)
     * 堆中元素的索引从1开始
     * @param capacity
     */
    public HeapMax(int capacity){
        int[] heapArr = new int[capacity+1];

    }

    PriorityQueue p = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    /**
     * heapify插入数据  时间复杂度 O(n)
     * @param arr
     * @param n
     */
    public HeapMax(int[] arr,int n){

    }

    /**
     * 插入元素的时候 从最小的叶子节点向上遍历父节点 构建最大堆
     * @param k
     */
    private void shiftUp(int k){

    }

    /**
     * 删除元素时 从根节点向下遍历 构建最大堆
     * @param k
     */
    private void shiftDown(int k){

    }

    private static void swap(int[] arr,int m,int n){
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

}
