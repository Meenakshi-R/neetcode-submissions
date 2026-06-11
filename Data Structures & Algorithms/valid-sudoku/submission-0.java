class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                     String keyWord = "(" + board[i][j] + ")";
                     if (!set.add(i+keyWord) ||
                         !set.add(keyWord+j) ||
                         !set.add((i/3) + keyWord + (j/3))) {
                               return false;
                         }
                }
            }
        }
        return true;
    }
}
