package DP;

/*
dp[i] = max(dp[j]*dp[i-j])
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 2; i < n+1; i++) {
            for(int j = 1; j < i+1; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i-j]*j, (i-j)*j));
            }
        }
        return dp[n];
    }
}
