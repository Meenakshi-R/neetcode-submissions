class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int prev1_buy = 0, prev2_buy = 0, prev1_sell = 0;

        for (int i=n-1; i>=0; i--) {
            int dp_buy = Math.max(-prices[i] + prev1_sell, prev1_buy);
            int dp_sell = Math.max(prev2_buy + prices[i], prev1_sell);

            prev2_buy = prev1_buy;
            prev1_buy = dp_buy;
            prev1_sell = dp_sell;
        }
        return prev1_buy;
    }
}