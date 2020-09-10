package com.tongle.sheldon.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Tongle
 * @date 2020-05-03
 * @description 求两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标
 * //给定 nums = [2, 7, 11, 15], target = 9
 */
public class SumOfTwoNumber {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 7, 11, 15};
        int target = 9;
        List<Integer> list =null;
//      list = getIndexMethod_1(arr,target);
        list = getIndexMethod_2(arr,target);

        list.forEach(x-> System.out.print(x+"\t"));
    }

    /**
     * 使用哈希表:值和索引对应关系 一般想到用哈希表
     * 时间复杂度O(n)
     * @param arr
     * @param target
     * @return
     */
    private static List<Integer> getIndexMethod_2(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int loop =0;
        for (int i = 0; i < arr.length; i++) {
            int other = target - arr[i];
            if(map.containsKey(other) && map.get(other)!=arr[i]){
                list.add(i);
                list.add(map.get(other));
            }
            map.put(arr[i],i);
        }
        return list;
    }

    /**
     * 暴力解法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param arr
     * @param target
     * @return
     */
    private static List<Integer> getIndexMethod_1(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        int loop =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length; j++) {
                if(arr[i] + arr[j] == target){
                    list.add(i);
                    list.add(j);
                    return list;
                }
                System.out.println("循环次数："+ (++loop) );
            }
        }
        return list;
    }
}
