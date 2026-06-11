class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            max = Math.max(max, Math.abs(price - minPrice));
        }
        return max;
    }
}
