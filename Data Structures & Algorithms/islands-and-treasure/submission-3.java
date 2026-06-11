class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];

            for (int[] dir : dirs) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;

                if (newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[]{newRow, newCol});
                grid[newRow][newCol] = 1+grid[row][col];
            }
        }
    }
}
