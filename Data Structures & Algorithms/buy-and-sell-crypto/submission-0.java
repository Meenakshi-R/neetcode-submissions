class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
          return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for (int i=0; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, Math.abs(prices[i]-minPrice));
        }
        return maxProfit;
    }
}
