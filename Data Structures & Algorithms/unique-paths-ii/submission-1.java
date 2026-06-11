class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[n-1] = 1;

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (i==m-1 && j==n-1) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                else {
                    dp[j] += dp[j+1];
                }
            }
        }
        return dp[0];
    }
}