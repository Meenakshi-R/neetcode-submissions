class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
               int[] current = queue.poll();
               int row = current[0], col = current[1];

                for (int[] dir : dirs) {
                    int nextRow = row + dir[0], nextCol = col + dir[1];
                    if (nextRow<0 || nextRow>=n || nextCol<0 || nextCol>=m || grid[nextRow][nextCol] != 1) {
                       continue;
                    }
                    grid[nextRow][nextCol] = 2;
                    queue.offer(new int[]{nextRow, nextCol});
                    fresh--;
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
