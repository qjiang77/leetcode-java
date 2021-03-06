package DP;

import java.util.*;

/*
416. Partition Equal Subset Sum (Medium)

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

dp[i]，表示数字i是否是原数组的任意个子集合之和

 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if(sum % 2 != 0) return false;
        int W = sum/2;
        boolean[] dp = new boolean[W+1];
        dp[0] = true;
        Arrays.sort(nums);
        for(int num : nums) {
            for(int i = W; i >= num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[W];
    }

    public int computeArraySum(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum = sum+num;
        }
        return sum;
    }
}
