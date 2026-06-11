class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean endOfWord;
}

class Solution {
    Set<String> result = new HashSet<>();
    Trie root = new Trie();
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        addWords(root, words);
        visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                dfs(board, "", i, j, m, n, root);
            }
        }
        return new ArrayList<>(result);
    }

    private void addWords(Trie root, String[] words) {
        for (String word : words) {
            Trie current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new Trie());
                current = current.children.get(ch);
            }
            current.endOfWord = true;
        }
    }

    private void dfs(char[][] board, String word, int i, int j, int m, int n, Trie node) {
        if (i<0 || i>=m || j<0 || j>=n || visited[i][j] || !node.children.containsKey(board[i][j])) {
            return;
        }
        visited[i][j] = true;
        word += board[i][j];
        node = node.children.get(board[i][j]);
        if (node.endOfWord) {
            result.add(word);
        }
        dfs(board, word, i+1, j, m, n, node);
        dfs(board, word, i-1, j, m, n, node);
        dfs(board, word, i, j+1, m, n, node);
        dfs(board, word, i, j-1, m, n, node);

        visited[i][j] = false;
    }
}
