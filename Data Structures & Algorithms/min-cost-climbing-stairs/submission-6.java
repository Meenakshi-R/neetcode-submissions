class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0, result = 0;

        for (int i=2; i<=cost.length; i++) {
            result = Math.min(first+cost[i-1], second+cost[i-2]);
            second = first;
            first = result;
        }
        return first;
    }
}
