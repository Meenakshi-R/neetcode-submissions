class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visit = new boolean[rows][cols];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        visit[0][0] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[1], col = node[2];
            time = node[0];

            if (row == rows-1 && col == cols-1) {
                return time;
            }

            for (int[] dir : dirs) {
                int r = row+dir[0], c = col+dir[1];
                if (r<0 || r>=rows || c<0 || c>=cols || visit[r][c]) {
                    continue;
                }
                queue.offer(new int[]{Math.max(grid[r][c], time), r, c});
                visit[r][c] = true;
            }
        }
        return time;
    }
}