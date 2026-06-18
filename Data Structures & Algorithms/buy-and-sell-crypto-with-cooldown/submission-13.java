class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_buy = 0, dp_sell = 0, prev_buy = 0, prev_sell = 0, prev2_buy = 0;

        for (int i=n-1; i>=0; i--) {
            dp_buy = Math.max(-prices[i]+prev_sell, prev_buy);
            dp_sell = Math.max(prices[i]+prev2_buy, prev_sell);
                
            prev2_buy = prev_buy;
            prev_buy = dp_buy;
            prev_sell = dp_sell;
        }
        return prev_buy;
    }
}