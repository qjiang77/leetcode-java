package DP;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int curAmount = 1;
        while(curAmount < amount+1) {
            int min = -1;
            for(int coin : coins) {
                if(curAmount >= coin && dp[curAmount-coin] != -1) {
                    if(min == -1) {
                        min = 1+dp[curAmount-coin];
                    }else {
                        min = Math.min(min, 1+dp[curAmount-coin]);
                    }
                }
            }
            dp[curAmount] = min;
            curAmount++;
        }
        return dp[amount];
    }
}
