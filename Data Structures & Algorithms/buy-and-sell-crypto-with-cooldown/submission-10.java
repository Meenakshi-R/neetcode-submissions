class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp1_buy = 0, dp2_buy = 0, dp1_sell = 0;

        for (int i=n-1; i>=0; i--) {
            int dp_buy =  Math.max((-prices[i] + dp1_sell), dp1_buy);
               
            int sell = i+2 < n ? prices[i] + dp2_buy : prices[i];
            int dp_sell = Math.max(sell, dp1_sell); 

            dp2_buy = dp1_buy;
            dp1_buy = dp_buy;
            dp1_sell = dp_sell;
        }
        return dp1_buy;
    }
}