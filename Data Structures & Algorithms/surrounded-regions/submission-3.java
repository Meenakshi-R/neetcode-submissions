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

    private void dfs(char[][] board, int row, int col, int rows, int cols) {
        if (row<0 || row>=rows || col<0 || col>=cols || board[row][col] != 'O') {
            return;
        }
        board[row][col] = 'T';
        dfs(board, row+1, col, rows, cols);
        dfs(board, row, col+1, rows, cols);
        dfs(board, row-1, col, rows, cols);
        dfs(board, row, col-1, rows, cols);
    }
}
