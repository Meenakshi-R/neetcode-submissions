class Solution {
    private void solve(int col, char[][] board, List<List<String>> result, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
         if (col == board.length) {
            result.add(construct(board));
            return;
         }
         for (int row=0; row<board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[col+row] == 0 && 
                                   upperDiagonal[board.length-1+col-row]==0) {
                  board[row][col] = 'Q';
                  leftRow[row] = 1;
                  lowerDiagonal[col+row] = 1;
                  upperDiagonal[board.length-1+col-row] = 1;
                  solve(col+1, board, result, leftRow, lowerDiagonal, upperDiagonal);
                  board[row][col] = '.';
                  leftRow[row] = 0;
                  lowerDiagonal[col+row] = 0;
                  upperDiagonal[board.length-1+col-row] = 0;
            }
         }
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<board.length; i++) {
             String s = new String(board[i]);
            result.add(s);
        }
        return result;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
         }
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];

        solve(0, board, result, leftRow, lowerDiagonal, upperDiagonal);
        return result;
    }
}
