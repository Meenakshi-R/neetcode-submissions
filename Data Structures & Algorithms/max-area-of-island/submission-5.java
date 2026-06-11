class Solution {
    int maxNow = 0, maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    maxNow = 0;
                    dfs(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, maxNow);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int n, int m) {
        if (i<0 || i>=n || j<0 || j>=m || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        maxNow++;
        dfs(grid, i+1, j, n, m);
        dfs(grid, i, j+1, n, m);
        dfs(grid, i-1, j, n, m);
        dfs(grid, i, j-1, n, m);

        return maxNow;
    }
}