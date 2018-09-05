package DP;

import java.util.*;

/*
For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
return minimum

构建squareList，有规律等式:可以构成n的平方
    1
    1+3
    1+3+5
    1+3+5+7
    ……

其他思路，类似与coin change的题目
 */

public class PerfectSquares {
    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while(square <= n) {
            squareList.add(square);
            square = square+diff;
            diff = diff+2;
        }
        return squareList;
    }
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            int min = Integer.MAX_VALUE;
            for(int square : squareList) {
                if(square > i) {
                    break;
                }
                min = Math.min(min, dp[i-square]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
