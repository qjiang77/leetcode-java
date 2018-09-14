package DP;

public class Note_StockProblem {
    /*
    【股票买卖模型】

    在股票交易中，三种操作：买入，卖出，不动
    限制条件：买入时必须没有股票，卖出时必须有股票
     */

    // 1. 只允许进行一次买卖的股票交易
    public int maxProfit1(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int maxProfit = 0;
        int curMin = prices[0];
        for(int i = 1; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-curMin);
        }
        return maxProfit;
    }

    // 2. 交易次数不限
    //  最大利润为每次都买卖
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int max = 0;
        for(int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i-1];
            if(diff > 0) max = max + diff;
        }
        return max;
    }

    // 3. 最多交易两次
    // 第i天之前和第i天之后的最大收益
    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];

        int curMin = prices[0];
        for(int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i-1], prices[i]-curMin);
        }

        int curMax = prices[n-1];
        for(int i = n-2; i > -1; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i+1], curMax-prices[i]);
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, postProfit[i]+preProfit[i]);
        }
        return max;
    }

    // 4. 最多交易k次
    // local[i][j]意味着在第i天一定有交易（卖出）发生
    // global[i][j]就是我们所求的前i天最多进行k次交易的最大收益
    public int maxProfit4(int k, int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int days = prices.length;
        if(k >= days) return maxProfit2(prices);

        int[][] local = new int[days][k+1];
        int[][] global = new int[days][k+1];

        for(int i = 1; i < days; i++) {
            int diff = prices[i] - prices[i-1];

            for(int j = 1; j < k+1; j++) {
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
                local[i][j] = Math.max(global[i-1][j-1], local[i-1][j]+diff);
            }
        }
        return global[days-1][k];
    }

    // 5. Cooldown
    public int maxProfit(int[] prices) {

    }
}
