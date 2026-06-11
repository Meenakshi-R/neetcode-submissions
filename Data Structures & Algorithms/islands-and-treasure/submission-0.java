class Solution {
    private void dfs (int[][] grid, int i, int j) {


    }

    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return;
        }
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0) {
                     queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0){
            return;
        }
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r<0 || c<0 || r>=n || c>=m || grid[r][c] != Integer.MAX_VALUE) {
                     continue;
                }
                queue.add(new int[]{r, c});
                grid[r][c] = grid[row][col]+1;
            }
        }
    }
}
