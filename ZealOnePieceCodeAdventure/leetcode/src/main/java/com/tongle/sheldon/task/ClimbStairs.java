package com.tongle.sheldon.task;

/**
 * @author Tongle
 * @date 2020-05-03
 * @description 爬楼梯
 * 假设你正在爬楼梯，需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶，你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n = 2;
//        int cnt = getSumChoices_1(5);
        int cnt = getSumChoices_2(5);
        System.out.println(cnt);

    }

    /**
     * 动态规划的方式实现,避免了递归方式的一些子问题的重复计算
     * 时间复杂度：O(n)
     * 将中间的状态保存到一个表里，这里只有一个维度，
     * 所以一维数组可以解决问题
     * 因为数组下标是董0开始的，所以将数组长度设置为n+1，dp[n]就是
     * 最终我们要求的状态结果
     * @param n
     * @return
     */
    private static int getSumChoices_2(int n) {
        int[] dp = new int[n+1];
        //设置最初的状态
        dp[0]=1;
        dp[1] =1;
        //状态转移
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 递归的方式实现
     * 时间复杂度：O(2^n)
     * @param
     * @return
     * 分析：
     * 第n阶台阶由第n-2 或者第n-1台阶上来的
     * f(n) = f(n-1) + f(n-2)
     * f(n):到达第n阶的的方法数
     */
    private static int getSumChoices_1(int n) {
        int sum =0;
        if(n<0){
            return 0;
        }
        if(n==0){
            sum += 1;
        }
        sum += getSumChoices_1(n-1) + getSumChoices_1(n-2);
        return sum;
    }
}
