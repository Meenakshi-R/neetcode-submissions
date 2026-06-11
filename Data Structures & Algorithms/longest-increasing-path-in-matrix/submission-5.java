class Solution {
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int LIP = Integer.MIN_VALUE;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                LIP = Math.max(LIP, dfs(matrix, i, j, Integer.MIN_VALUE));
            }
        }
        return LIP;
    }

    private int dfs(int[][] matrix, int i, int j, int prev) {
        if (i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j] <= prev) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int result = 1;
        result = Math.max(result, 1+dfs(matrix, i+1, j, matrix[i][j]));
        result = Math.max(result, 1+dfs(matrix, i-1, j, matrix[i][j]));
        result = Math.max(result, 1+dfs(matrix, i, j+1, matrix[i][j]));
        result = Math.max(result, 1+dfs(matrix, i, j-1, matrix[i][j]));

        return memo[i][j] = result;
    }
}