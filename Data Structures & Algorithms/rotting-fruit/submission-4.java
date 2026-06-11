class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time = 0;
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
               int[] current = queue.poll();
               int row = current[0], col = current[1];

               for (int[] dir : dirs) {
                    int newRow = dir[0]+row;
                    int newCol = dir[1]+col;
                    if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols || grid[newRow][newCol] != 1) {
                       continue;
                    }
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
                    fresh--;
               }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
