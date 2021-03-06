package DP;

/*
Leetcode 303. Range Sum Query - Immutable (Easy)

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
求区间 i ~ j 的和，可以转换为 sum[j] - sum[i-1]，其中 sum[i] 为 0 ~ i 的和。
 */
class NumArray {
    private int[] dp;
    public NumArray(int[] nums) {
        dp = new int[nums.length+1];
        for(int i = 1; i < nums.length+1; i++) {
            dp[i] = dp[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return  dp[j+1]-dp[i];
    }
}
