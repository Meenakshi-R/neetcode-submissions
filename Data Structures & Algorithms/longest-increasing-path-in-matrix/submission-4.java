class Solution {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}}; 
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int prev = Integer.MIN_VALUE, longest = 0;
        dp = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, m, n));
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = 1;
        for (int[] dir : dirs) {
            int nR = dir[0] + i;
            int nC = dir[1] + j;
            if (nR<0 || nR>=m || nC<0 || nC>=n || matrix[nR][nC] <= matrix[i][j]) {
                continue;
            }
            result = Math.max(result, 1 + dfs(matrix, nR, nC, m, n));
        }
        return dp[i][j] = result;
    }
}
