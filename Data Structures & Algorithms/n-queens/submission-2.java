class Solution {
    List<List<String>> result = new ArrayList<>();
    int[] leftRow;
    int[] lowerDiagonal;
    int[] upperDiagonal;

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        leftRow = new int[n];
        lowerDiagonal = new int[2*n-1];
        upperDiagonal = new int[2*n-1];

        solve(board, 0, n);

        return result;
    }

    private void solve(char[][] board, int col, int n) {
        if (col >= n) {
            constructResult(board);
            return;
        }
        for (int row=0; row<n; row++) {
            if (leftRow[row]==0 && lowerDiagonal[col+row]==0 && upperDiagonal[n-1+col-row]==0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[col+row] = 1;
                upperDiagonal[n-1+col-row] = 1;

                solve(board, col+1, n);

                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[col+row] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
    }

    private void constructResult(char[][] board) {
        List<String> currBoard = new ArrayList<>();

        for (int i=0; i<board.length; i++) {
            String s = new String(board[i]);
            currBoard.add(s);
        }
        result.add(currBoard);
    }
}
