class Solution {
    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        visit = new boolean[rows][cols];
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (dfs(board, word, i, j, 0, rows, cols)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k, int rows, int cols) {
        if (k==word.length()) {
            return true;
        }
        if (i<0 || i>=rows || j<0 || j>=cols || visit[i][j] || word.charAt(k) != board[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean result =  dfs(board, word, i+1, j, k+1, rows, cols) ||
               dfs(board, word, i, j+1, k+1, rows, cols) ||
               dfs(board, word, i-1, j, k+1, rows, cols) ||
               dfs(board, word, i, j-1, k+1, rows, cols);
        visit[i][j] = false;
        return result;
    }
}
