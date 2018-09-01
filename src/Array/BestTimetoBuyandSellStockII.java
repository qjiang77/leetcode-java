package Array;

public class BestTimetoBuyandSellStockII {
    //多次买卖
    //贪心策略
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 4)
            return 0;
        int profit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
