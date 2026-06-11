class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length, M = grid[0].length;

        boolean[][] visited = new boolean[N][M];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int amount = current[0], row = current[1], col = current[2];

            if (row == N-1 && col == M-1) {
                return amount;
            }
            visited[row][col] = true;
            for (int[] dir : dirs) {
                int nextRow = row+dir[0], nextCol = col+dir[1];
                if (nextRow<0 || nextRow>=N || nextCol<0 || nextCol>=M || visited[nextRow][nextCol]) {
                    continue;
                }
                minHeap.offer(new int[]{Math.max(amount, grid[nextRow][nextCol]), nextRow, nextCol});
            }
        }
        return -1;
    }
}
