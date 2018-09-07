package DP;

/*
583. Delete Operation for Two Strings
问题描述
Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example :

Input: “sea”, “eat”
Output: 2
Explanation: You need one step to make “sea” to “ea” and another step to make “eat” to “ea”.

【最长公共子串】的变体题目
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 1; i < n1+1; i++) {
            for(int j = 1; j < n2+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int maxLength = dp[n1][n2];
        int min = n1-maxLength+n2-maxLength;
        return min;
    }
}
