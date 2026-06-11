class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int result = 0, fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] node = queue.poll(); 
                int row = node[0];
                int col = node[1];

                for (int[] dir : dirs) {
                    int r = row+dir[0];
                    int c = col+dir[1];
                    if (r<0 || c<0 || r>=n || c>=m || grid[r][c] != 1) {
                       continue;
                    }
                    grid[r][c] = 2;
                    queue.add(new int[]{r, c});
                    fresh--;
                }
            }
            result++;
        }
        return fresh == 0 ? result : -1;
    }
}
