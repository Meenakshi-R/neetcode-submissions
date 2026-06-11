class Solution {
    int[][] dirs = {{-1,0}, {0,-1}, {1, 0}, {0,1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                dp[i][j] = -1;
            }
        }
        int result = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                result = Math.max(result, dfs(i, j, matrix, Integer.MIN_VALUE, dp, rows, cols));
            }
        }
        return result;
    }

    private int dfs(int r, int c, int[][] matrix, int prev, int[][] dp, int m, int n) {
        if (r<0 || r>=m || c<0 || c>=n || matrix[r][c] <= prev) {
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int result = 1;
        for (int[] dir : dirs) {
            result = Math.max(result, 
                          1+ dfs(r+dir[0], c+dir[1], matrix, matrix[r][c], dp, m, n));
        }
        return dp[r][c] = result;
    }
}
