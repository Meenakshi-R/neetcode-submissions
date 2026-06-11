class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev1_sell = 0, prev1_buy = 0, prev2_buy = 0, dp_buy=0, dp_sell=0;

        for (int i=n-1; i>=0; i--) {
            for (int buy=1; buy>=0; buy--) {
                if (buy == 1) {
                    dp_buy = Math.max(prev1_buy, -prices[i]+prev1_sell);
                }
                else {
                    dp_sell = Math.max(prev1_sell, prices[i]+prev2_buy);
                }
            }
            prev2_buy = prev1_buy;
            prev1_buy = dp_buy;
            prev1_sell = dp_sell;
        }
        return prev1_buy;
    }
}
