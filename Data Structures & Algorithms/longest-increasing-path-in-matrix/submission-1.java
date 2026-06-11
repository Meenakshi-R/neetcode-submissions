class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int result = 0;
        dp = new int[m+1][n+1];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result = Math.max(result, dfs(matrix, i, j, m, n, Integer.MIN_VALUE));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int prev) {
        if (i<0 || j<0 || i>=m || j>=n || matrix[i][j] <= prev) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int result = 0;
        for (int[] dir : dirs) {
            result = Math.max(result, 1+dfs(matrix, i+dir[0], j+dir[1], m, n, matrix[i][j]));
        }
        return dp[i][j] = result;
    }
}
