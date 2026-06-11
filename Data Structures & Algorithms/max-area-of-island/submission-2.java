class Solution {
    int maxArea = 0;
    int maxNow = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    maxNow = 0;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j, int rows, int cols) {
        if (i<0 || i>=rows || j<0 || j>=cols || grid[i][j] != 1) {
            return;
        }
        maxNow++;
        grid[i][j] = 0;
        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i, j+1, rows, cols);
        dfs(grid, i-1, j, rows, cols);
        dfs(grid, i, j-1, rows, cols);
        maxArea = Math.max(maxArea, maxNow);
    }
}
