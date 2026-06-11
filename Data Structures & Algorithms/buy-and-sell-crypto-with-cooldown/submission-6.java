class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int i, boolean buy) {
        if (i>=prices.length) {
            return 0;
        }
        if (buy) {
            return Math.max(dfs(prices, i+1, buy), -prices[i] + dfs(prices, i+1, !buy));
        }
        else {
            return Math.max(dfs(prices, i+1, buy), prices[i] + dfs(prices, i+2, !buy));
        }
    }
}
