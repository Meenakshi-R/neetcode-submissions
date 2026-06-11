class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> input = new ArrayList<>();
        for (int num : nums) {
            input.add(num);
        }
        input.add(0, 1);
        input.add(1);
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        for (int i=n; i>=1; i--) {
            for (int j=1; j<=n; j++) {
                if (i > j) {
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int ind = i; ind<=j; ind++) {
                    int cost = input.get(i-1)*input.get(ind)*input.get(j+1) + 
                                            dp[i][ind-1] + dp[ind+1][j];
                    max = Math.max(max, cost);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }
}
