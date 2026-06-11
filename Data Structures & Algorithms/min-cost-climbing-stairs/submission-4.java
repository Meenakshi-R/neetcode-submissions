class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int opt1 = 0, opt2 = 0, result = 0;

        for (int i=2; i<=n; i++) {
            result = Math.min(opt1+cost[i-1], opt2+cost[i-2]);
            opt2 = opt1;
            opt1 = result;
        }
        return result;
    }
}

