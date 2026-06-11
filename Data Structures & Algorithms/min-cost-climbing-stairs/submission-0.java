class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        int first=cost[0], second=cost[1], result=0;
        if (n <= 2) {
            return Math.min(first, second);
        }
        for (int i=2; i<n; i++) {
            result = cost[i] + Math.min(first, second);
            first = second;
            second = result;
        }
        return Math.min(first, second);
    }
}
