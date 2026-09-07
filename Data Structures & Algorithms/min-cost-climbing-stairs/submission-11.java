class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = 0, second = 0;

        for (int i=2; i<=n; i++) {
            int result = Math.min(second+cost[i-2], first + cost[i-1]);
            second = first;
            first = result;
        }
        return first;
    }
}
