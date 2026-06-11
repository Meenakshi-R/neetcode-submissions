class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, rows, cols));
                }
            }
        }
        return maxArea; 
    }

    private int dfs(int[][] grid, int i, int j, int rows, int cols) {
        if (i<0 || i>=rows || j<0 || j>=cols || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int result = 1;

        result += dfs(grid, i+1, j, rows, cols);
        result += dfs(grid, i, j+1, rows, cols);
        result += dfs(grid, i-1, j, rows, cols);
        result += dfs(grid, i, j-1, rows, cols);

        return result;
    }
}
