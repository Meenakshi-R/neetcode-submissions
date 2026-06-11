class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int time = current[0], row = current[1], col = current[2];

            if (row == N-1 && col == N-1) {
                return time;
            }
            for (int[] dir : dirs) {
                int nextRow = row+dir[0];
                int nextCol = col+dir[1];

                if (nextRow<0 || nextRow>=N || nextCol<0 || nextCol>=N || visited[nextRow][nextCol]) {
                    continue;
                }
                queue.offer(new int[]{Math.max(time, grid[nextRow][nextCol]), nextRow, nextCol});
                visited[nextRow][nextCol] = true;
            }
        }
        return N*N;
    }
}