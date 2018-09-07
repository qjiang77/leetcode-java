package DP;

/*
718. Maximum Length of Repeated Subarray
题目描述
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example :

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int n1 = A.length, n2 = B.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        int ret = 0;
        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret;
    }
}
