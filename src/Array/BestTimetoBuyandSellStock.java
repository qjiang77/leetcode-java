package Array;

public class BestTimetoBuyandSellStock {
    // 数组代表股票价格
    // 只能一次买卖
    // time： on；space：o1
    public static  int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        // 两个index变量
        int min = prices[0];
        int profit = 0;

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;

    }
}
