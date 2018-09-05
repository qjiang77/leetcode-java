package DP;

/*
最长递增子序列
300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubs {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            int max = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for(int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
