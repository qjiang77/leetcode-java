package DP;

import java.util.*;

/*
Leetcode 646. Maximum Length of Pair Chain (Medium)

Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
 */
public class MaxLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0 || pairs[0].length == 0) return 0;
        int length = pairs.length;
        int[] dp = new int[length];
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        for(int i = 0; i < length; i++) {
            int max = 1;
            for(int j = 0; j < length; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
        }
        int ret = 0;
        for(int i = 0; i < length; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
