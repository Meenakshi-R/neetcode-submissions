class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean endOfWord;
}

class Solution {
    Trie root = new Trie();
    Set<String> result;
    boolean[][] visit;

    public List<String> findWords(char[][] board, String[] words) {
        addWords(words);
        int m = board.length, n = board[0].length;
        result = new HashSet<>();
        visit = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(board, root, i, j, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void addWords(String[] words) {
        for (String word : words) {
            Trie current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new Trie());
                current = current.children.get(ch);
            }
            current.endOfWord = true;
        }
    }

    private void dfs(char[][] board, Trie node, int i, int j, String word) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || visit[i][j] || !node.children.containsKey(board[i][j])) {
            return;
        }
        visit[i][j] = true;
        node = node.children.get(board[i][j]);
        word+=board[i][j];
        if (node.endOfWord) {
            result.add(word);
        }
        dfs(board, node, i+1, j, word);
        dfs(board, node, i, j+1, word);
        dfs(board, node, i-1, j, word);
        dfs(board, node, i, j-1, word);

        visit[i][j] = false;
    }
}