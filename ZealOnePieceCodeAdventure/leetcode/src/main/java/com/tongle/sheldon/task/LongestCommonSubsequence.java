package com.tongle.sheldon.task;

/**
 * @author Tongle
 * @date 2020-05-05
 * @description 最长子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。

 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "abce";
        String str2 = "acde";
        //动态规划解决
        int length = longestCommonSubsequence( str1, str2);
        System.out.println(length);
    }

    /**
     * 时间复杂度：O(n*m)
     * 思路分析：
     * 这里有两个维度：字符串1和字符串2的下标，用二维数组来表示状态
     * dp[i][j]:第一个字符串的第1至i号位字符部分与第二个字符串的第1至j号位字符部分的LCS长度
     * 确定状态转移方程：
     * ① 当 S1i==S2j 时，那么就能在 S1 的前 i-1 个字符与 S2 的前 j-1 个
     * 字符最长公共子序列的基础上再加上 S1i 这个值，最长公共子序列长度加 1，
     * 即 dp[i][j] = dp[i-1][j-1] + 1。
     * ② 当 S1i != S2j 时，此时最长公共子序列为 S1 的前 i-1 个字符和 S2 的前 j 个字符最长公共子序列，
     * 或者 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列，取它们的最大者，
     * 即 dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }。
     * @param str1
     * @param str2
     * @return
     */
    private static int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        //定义最初的状态
        for (int i = 0; i < str1.length()+1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                if(i==0 || j==0){
                    dp[i][j] =0;
                    continue;
                }
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
