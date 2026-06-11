class Solution {
    public int swimInWater(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] element = minHeap.poll();
            int time = element[0], r = element[1], c = element[2];
            if (r == N-1 && c == N-1) {
                return time;
            }
            for (int[] dir : dirs) {
                int nr = r+dir[0], nc = c+dir[1];

                if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc]) {
                    minHeap.offer(new int[] {Math.max(time, grid[nr][nc]), nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return N*N;
    }
}
