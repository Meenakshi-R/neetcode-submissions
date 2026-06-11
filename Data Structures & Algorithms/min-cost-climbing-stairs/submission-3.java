class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int opt1 = 0, opt2 = 0, result = 0;
        int n = cost.length;

        for (int i=2; i<=n; i++) {
            int first = opt1 + cost[i-1];
            int second = opt2 + cost[i-2];
            result = Math.min(first, second);
            opt2 = opt1;
            opt1 = result;
        }
        return result;
    }
}