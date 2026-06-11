class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n+1];
        for (int j = 0; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;
        }
        dp[n-1] = grid[m-1][n-1];

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i==m-1 && j==n-1) {
                    continue;
                }
                dp[j] = grid[i][j] + Math.min(dp[j+1], dp[j]);
            }
        }
        return dp[0];
    }
}