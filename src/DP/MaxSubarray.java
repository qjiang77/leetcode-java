package DP;

/*
Leetcode 53. Maximum Subarray (Easy)

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

    最大连续子数组和问题：
    事实上，当我们令currSum为当前最大子数组的和，maxSum为最后要返回的最大子数组的和，当我们往后扫描时，

！！！！！对第j+1个元素有两种选择：
        要么放入前面找到的子数组，要么做为新子数组的第一个元素；！！！！
如果currSum加上当前元素a[j]后不小于a[j]!!! 则令currSum加上a[j]，否则currSum重新赋值，置为下一个元素，即currSum = a[j]。
同时，当currSum > maxSum，则更新maxSum = currSum，否则保持原值，不更新。
即

currSum = max(a[j], currSum + a[j])
maxSum = max(maxSum, currSum)
 */
public class MaxSubarray {
    public int maxSubarray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curSum = nums[0];
        int maxSum = curSum;
        for(int i = 1; i < nums.length; i++) {
            curSum = curSum+nums[i]>nums[i]? curSum+nums[i] : nums[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
