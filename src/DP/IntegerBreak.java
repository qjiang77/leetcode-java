package DP;

/*
dp[i] = max(dp[j]*dp[i-j])
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j= 0; j < n; j++) {
                dp[i] = Math.max(double(dp[j]*dp[i-j]));
            }
        }
    }
}
