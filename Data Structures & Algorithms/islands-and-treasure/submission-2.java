class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];

            for (int[] dir : dirs) {
                int nr = dir[0]+row;
                int nc = dir[1]+col;

                if(nr<0 || nr>=rows || nc<0 || nc>=cols || grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[]{nr, nc});
                grid[nr][nc] = 1+grid[row][col];
            }
        }
    }
}
