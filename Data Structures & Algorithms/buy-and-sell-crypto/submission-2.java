class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=Integer.MIN_VALUE, minPrice = Integer.MAX_VALUE;

        for (int price: prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, Math.abs(price-minPrice));
        }
        return maxProfit;
    }
}
