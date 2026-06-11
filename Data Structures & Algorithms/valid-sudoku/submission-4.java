class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] != '.') {
                    String key = "(" + board[i][j] + ")";

                    if (!set.add(i+key) || !set.add(key+j) || !set.add((i/3)+key+(j/3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
