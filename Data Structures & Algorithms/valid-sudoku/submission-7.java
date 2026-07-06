class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
        List<String> decoded = new ArrayList<>();
                    String key = "("+ ch + ")";
                    if (!set.add(i+key) || !set.add(key+j) || !set.add((i/3)+key+(j/3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
