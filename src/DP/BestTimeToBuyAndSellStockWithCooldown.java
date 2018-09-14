package DP;

/*
309. Best Time to Buy and Sell Stock with Cooldown
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];
        s1[0] = buy[0] = -prices[0];
        s2[0] = sell[0] = 0;
        for (int i = 0; i < n; i++) {
            buy[i] = s2[i-1]-prices[i];
            s1[i] = Math.max(buy[i-1], s1[i-1]);
            sell[i] = Math.max(buy[i-1],s1[i-1])+prices[i];
            s2[i] = Math.max(s2[i-1], sell[i-1]);
        }
        return Math.max(sell[n-1],s2[n-1]);
    }
}
