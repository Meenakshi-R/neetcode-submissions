class Solution {
    int maxArea = 0, maxNow = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    maxNow = 0;
                    dfs(grid, i, j);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        maxNow++;
        dfs(grid, i, j+1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        maxArea = Math.max(maxArea, maxNow);
    }
}