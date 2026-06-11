class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, result = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];

                for (int[] dir : dirs) {
                    int newRow = row+dir[0], newCol = col+dir[1];
                    if (newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length || grid[newRow][newCol] != 1) {
                       continue;
                    }
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
                    fresh--;
                }
            }
            result++; 
        }
        return fresh == 0 ? result : -1;
    }
}
