class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int longestPath = 0;
        memo = new int[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, Integer.MIN_VALUE, rows, cols));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int i, int j, int prev, int rows, int cols) {
        if (i<0 || i>=rows || j<0 || j>=cols || matrix[i][j] <= prev) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int result = 1;
        for (int[] dir : dirs) {
            result = Math.max(result, 1 + dfs(matrix, i+dir[0], j+dir[1], matrix[i][j], rows, cols));
        }
        return memo[i][j] = result;
    }
}
