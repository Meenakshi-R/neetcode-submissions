class Solution {
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;
        int time = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            time = element[0];
            int r = element[1], c = element[2];
            if (r == n- 1 && c == n-1) {
                return time;
            }
            for (int[] dir : directions) {
                int nr = r+dir[0], nc = c+dir[1];
                if (nr>=0 && nc>=0 && nr<n && nc<n && !visit[nr][nc]) {
                    queue.add(new int[] {Math.max(time, grid[nr][nc]), nr, nc});
                    visit[nr][nc] = true;
                }
            }
        }
        return n*n;
    }
}
