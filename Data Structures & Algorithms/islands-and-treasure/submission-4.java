class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0) {
                   queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];

            for (int[] dir : dirs) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow<0 || nextRow>=n || nextCol<0 || nextCol>=m || grid[nextRow][nextCol] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[]{nextRow, nextCol});
                grid[nextRow][nextCol] = grid[row][col] + 1;
            }
        }
    }
}
