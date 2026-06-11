class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[] dp = new int[cols+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[cols-1] = grid[rows-1][cols-1];

        for (int i=rows-1; i>=0; i--) {
            for (int j=cols-1; j>=0; j--) {
                if (i == rows-1 && j == cols-1) {
                    continue;
                }
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}