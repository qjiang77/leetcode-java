package DP;

import java.util.*;
/*
【斐波那契数列】
1. 组合数学————错排问题
    问题一：写信将n封信装到n个信封中，有多少全部错误的装法
    问题二：四个人写贺年卡互相赠送，贺年卡不能送给自己
    etc.

    这些问题都可以称为错排问题
    考虑一个有n个元素的排列，若一个排列中所有的元素都不在自己原来的位置上，那么这样的排列就称为原排列的一个错排

    信件错排：伯努利-欧拉的装错信封问题
    N信件和N信封，被打乱
    求错误装信方式的数量
solution:
    dp[i]，前i个信件信封错误方式的数量
    下面用递推的方法推导错排公式:
    当n个编号元素放在n个编号位置,元素编号与位置编号各不对应的方法数用M(n)表示,那么M(n-1)就表示n-1个编号元素放在n-1个编号位置,各不对应的方法数,其它类推.
    第一步,把第n个元素放在一个位置,比如位置k,一共有n-1种方法;
    第二步,放编号为k的元素,这时有两种情况.1,把它放到位置n,那么,对于剩下的n-2个元素,就有M(n-2)种方法;2,不把它放到位置n,这时,对于这n-1个元素,有M(n-1)种方法;

    dp[i] = (n-1)*(dp[i-2]+dp[i-1])

2. 母牛生产：
    题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死；
    第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛；
    每只小母牛 3 年之后成熟又可以生小母牛；
    给定整数 N，求 N 年后牛的数量；
solution：
    dp[i]记为i年后牛的数量
    dp[i] = dp[i-1]+dp[i-3]

【矩阵路径】
 */
class note{
    // elements could be +1/-1
    // return the minStep that make the array ascending
    // 求是数组变为递增数组的最小cost
    public int minStep(int[] a) {
        if(a == null || a.length == 0) return 0;
        // only int, char, float, double: value
        // array and etc.:address
        int l = a.length;
        int[] b = new int[l];
        for(int i = 0; i < l; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        int[] dp = new int[l+1];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                dp[j] = dp[j] + Math.abs(a[i]-b[j]);
                if(j>1) {
                    dp[j] = Math.min(dp[j-1], dp[j]);
                }
            }
        }
        return dp[l];
    }

    /*
【最长公共子序列】
对于两个子序列 S1 和 S2，找出它们最长的公共子序列。
(允许间隔计算，即允许不连续)

定义一个二维数组 dp 用来存储最长公共子序列的长度，其中 dp[i][j] 表示 S1 的前 i 个字符与 S2 的前 j 个字符最长公共子序列的长度。考虑 S1i 与 S2j 值是否相等，分为两种情况：

当 S1i==S2j 时，那么就能在 S1 的前 i-1 个字符与 S2 的前 j-1 个字符最长公共子序列的基础上再加上 S1i 这个值，最长公共子序列长度加 1，即 dp[i][j] = dp[i-1][j-1] + 1。
当 S1i != S2j 时，此时最长公共子序列为 S1 的前 i-1 个字符和 S2 的前 j 个字符最长公共子序列，或者 S1 的前 i 个字符和 S2 的前 j-1 个字符最长公共子序列，取它们的最大者，即 dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }。
综上，最长公共子序列的状态转移方程为：


对于长度为 N 的序列 S1 和长度为 M 的序列 S2，dp[N][M] 就是序列 S1 和序列 S2 的最长公共子序列长度。

与最长递增子序列相比，最长公共子序列有以下不同点：

针对的是两个序列，求它们的最长公共子序列。
在最长递增子序列中，dp[i] 表示以 Si 为结尾的最长递增子序列长度，子序列必须包含 Si ；在最长公共子序列中，dp[i][j] 表示 S1 中前 i 个字符与 S2 中前 j 个字符的最长公共子序列长度，不一定包含 S1i 和 S2j。
在求最终解时，最长公共子序列中 dp[N][M] 就是最终解，而最长递增子序列中 dp[N] 不是最终解，因为以 SN 为结尾的最长递增子序列不一定是整个序列最长递增子序列，需要遍历一遍 dp 数组找到最大者。

 */
    public int lengthOfLCS(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    /*
    【最长公共子串】&&【最长公共子数组】：要求一定要连续！！！
    Leetcode 718, 583
     */

    /*
【背包问题】:
(1) 0-1背包
有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。

     */


    // sum to j using first i numbers
    // dp[i][j] true, if dp[i-1][j-nums[i]]
    // 滚动数组进行压缩
    public int knapsack(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N+1][W+1];
        for(int i = 1; i < N+1; i++) {
            int w = weights[i-1], v = values[i-1];
            for(int j = 1; j < W+1; j++) {
                if(j >= w) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-w]+v);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    // 空间优化
    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W+1];
        for(int i = 1; i < W+1; i++) {
            int w = weights[i-1], v = values[i-1];
            for(int j = W; j >= 1; j--) {
                if(j >= w) {
                    dp[j] = Math.max(dp[j], dp[j-w]+v);
                }
            }
        }
        return dp[W];
    }

    //TODO: 背包问题的继续扩充

    /*
    【滚动数组】： 作用在于优化空间，主要应用在递推或动态规划中。
                 由于DP是自底向上的扩展过程，常常需要用到的是连续的解，因此可以利用滚动数组达到压缩存储的作用

     */
}

