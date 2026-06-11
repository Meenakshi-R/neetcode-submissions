class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<rows; i++) {
            pacQ.offer(new int[]{i, 0});
            atlQ.offer(new int[]{i, cols-1});
        }
        for (int i=0; i<cols; i++) {
            pacQ.offer(new int[]{0, i});
            atlQ.offer(new int[]{rows-1, i});
        }
        bfs(heights, pacQ, pac, rows, cols);
        bfs(heights, atlQ, atl, rows, cols);
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visit, int rows, int cols) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1];
            visit[row][col] = true;

            for (int[] dir : dirs) {
                int newRow = row+dir[0];
                int newCol = col+dir[1];

                if(newRow<0 || newRow>=rows || newCol<0 || newCol>=cols || visit[newRow][newCol] || heights[newRow][newCol] < heights[row][col]) {
                    continue;
                }
                queue.offer(new int[]{newRow, newCol});
            }
        }
    }
}
