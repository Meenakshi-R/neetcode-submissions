class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
               int[] current = queue.poll();
               int row = current[0], col = current[1];

               for (int[] dir : dirs) {
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];

                    if (newRow<0 || newRow>=rows || newCol<0 || newCol>=cols || grid[newRow][newCol] != 1) {
                        continue;
                    }
                    grid[newRow][newCol] = 2;
                    queue.offer(new int[]{newRow, newCol});
                    fresh--;
                }
            }
            result++;
        }
        return fresh == 0 ? result : -1;
    }
}
