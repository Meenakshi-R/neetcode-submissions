class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;

        for (int i=0; i<rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, rows, cols);
            }
            if (board[i][cols-1] == 'O') {
                dfs(board, i, cols-1, rows, cols);
            }
        }

        for (int i=0; i<cols; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, rows, cols);
            }
            if (board[rows-1][i] == 'O') {
                dfs(board, rows-1, i, rows, cols);
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int rows, int cols) {
        if (i<0 || i>=rows || j<0 || j>=cols || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        dfs(board, i+1, j, rows, cols);
        dfs(board, i-1, j, rows, cols);
        dfs(board, i, j+1, rows, cols);
        dfs(board, i, j-1, rows, cols);
    }
}
