package DP;

import java.util.*;

/*
377. Combination Sum IV (Medium)

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int i = 1; i < target+1; i++) {
            for(int num : nums) {
                if(i >= num) {
                    dp[i] = dp[i] + dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
