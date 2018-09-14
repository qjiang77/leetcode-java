package DP;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] buy = new int[n];
        int[] s1 = new int[n];
        int[] sell = new int[n];
        int[] s2 = new int[n];
        buy[0] = s1[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for(int i = 1; i < n; i++) {

            //TODO: Fill the code
        }
    }
}
