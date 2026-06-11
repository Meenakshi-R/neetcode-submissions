class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacVisited = new boolean[rows][cols];
        boolean[][] atlVisited = new boolean[rows][cols];

        for (int i=0; i<rows; i++) {
           pacQueue.offer(new int[]{i, 0});
           atlQueue.offer(new int[]{i, cols-1});
        }
        for (int i=0; i<cols; i++) {
            pacQueue.offer(new int[]{0, i});
            atlQueue.offer(new int[] {rows-1, i});
        }
        bfs(pacQueue, rows, cols, heights, result, pacVisited);
        bfs(atlQueue, rows, cols, heights, result, atlVisited);

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (pacVisited[i][j] && atlVisited[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(Queue<int[]> queue, int rows, int cols, int[][] heights, List<List<Integer>>result, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] coords = queue.poll();
            int r = coords[0], c = coords[1];

            visited[r][c] = true;

            for (int[] dir : dirs) {
                int newRow = r+dir[0];
                int newCol = c+dir[1];

                if (newRow<0 || newRow>= rows || newCol<0 || newCol>=cols || 
                                  heights[newRow][newCol] < heights[r][c] || visited[newRow][newCol]) {
                    continue;
                } 
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
