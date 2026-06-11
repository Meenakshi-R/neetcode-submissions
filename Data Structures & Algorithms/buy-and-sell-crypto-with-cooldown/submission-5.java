class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev1_sell = 0, prev1_buy = 0, prev2_buy = 0;

        for (int i=n-1; i>=0; i--) {
            int buy = Math.max(-prices[i]+prev1_sell, prev1_buy);
            int sell = Math.max(prices[i] +prev2_buy, prev1_sell);

            prev2_buy = prev1_buy;
            prev1_buy = buy;
            prev1_sell = sell;
        }
        return prev1_buy;
    }
}