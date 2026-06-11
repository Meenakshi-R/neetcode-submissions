class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) {
            return result;
        }
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int i=0; i<rows; i++) {
            pacQueue.offer(new int[]{i, 0});
            atlQueue.offer(new int[]{i, cols-1});
        }
        for (int i=0; i<cols; i++) {
            pacQueue.offer(new int[]{0, i});
            atlQueue.offer(new int[]{rows-1, i});
        }

        bfs(heights, pac, pacQueue);
        bfs(heights, atl, atlQueue);

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int r = element[0];
            int c = element[1];
            visited[r][c] = true;
            for (int[] dir : directions) {
                int nr = r+dir[0];
                int nc = c+dir[1];
                if (nr<0 || nr>=heights.length || nc<0 || nc>=heights[0].length || visited[nr][nc] ||
                                heights[nr][nc] < heights[r][c]) {
                                    continue;
                }
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
