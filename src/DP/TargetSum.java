package DP;

import java.util.*;
/*
494. Target Sum (Medium)

Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

 s1-s2 = target
 s1+s2+s1-s2 = target+s1+s2
 2s1 = targets+sum
 ==> s1 = (target+sum)/2

 [-sum, sum]
 动规的规模远小于枚举（dfs），因此用DP更佳
 */
public class TargetSum{
    // DP
    // way[i][j] = way[i-1][j-nums[i]]+way[i-1][j+nums[i]]
    // 优化空间二维到一维
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum = sum+num;
        }
        if(sum < S || (sum+S) % 2 != 0) return 0;
        int W = (sum+S)/2;
        int[] dp = new int[W+1];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int num : nums) {
            for(int i = W; i >= num; i--) {
                dp[i] = dp[i]+dp[i-num];
            }
        }
        return dp[W];
    }

    // DFS
    // Brute force: 尝试枚举所有情况
    // 如果规模太大就不适用
    public int dfsSolution(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    public int findTargetSumWays(int[] nums, int start, int S) {
        if(start == nums.length) {
            return S == 0? 1:0;
        }
        return findTargetSumWays(nums, start+1, S+nums[start])
                + findTargetSumWays(nums, start+1, S-nums[start]);
    }
}
