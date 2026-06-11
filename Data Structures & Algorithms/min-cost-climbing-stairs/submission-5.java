class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = 0, second = 0, result = 0;

        for (int i=2; i<=n; i++) {
            result = Math.min(first+cost[i-1], second+cost[i-2]);
            second = first;
            first = result;
        }
        return result;
    }
}