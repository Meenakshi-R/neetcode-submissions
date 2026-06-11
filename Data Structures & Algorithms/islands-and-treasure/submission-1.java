class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] treasure = queue.poll();
            int row = treasure[0], col = treasure[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow<0 || newRow>=rows || newCol<0 || newCol>=cols || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[]{newRow, newCol});
                grid[newRow][newCol] = 1+grid[row][col];
            } 
        }
    }
}
