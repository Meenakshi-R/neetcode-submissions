class Solution {
    public int integerBreak(int n) {
        if (n<=2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[2] = 1;

        for (int i=3; i<=n; i++) {
            for (int j=1; j<i; j++) {
               int remaining = i-j;
               dp[i] = Math.max(dp[i], Math.max(j*remaining, j*dp[remaining]));
            }
        }
        return dp[n];
    }
}