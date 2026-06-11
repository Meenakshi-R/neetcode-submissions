class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i<0 || i>=rows || j<0 || j>=cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i, j+1, rows, cols);
        dfs(grid, i, j-1, rows, cols);
        dfs(grid, i-1, j, rows, cols);
    }
}