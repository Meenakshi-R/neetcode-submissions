class Solution {
    private boolean[][] visit;
    private Set<String> result;

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
          children = new HashMap<>();
          endOfWord = false;
        }
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode current = root;
            for (char ch : w.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
            }
            current.endOfWord = true;
        }
        return root;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, String word) {
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || visit[i][j] ||
            !node.children.containsKey(board[i][j])) {
                return;
        }
        visit[i][j] = true;
        node = node.children.get(board[i][j]);
        word+= board[i][j];
        if (node.endOfWord) {
            result.add(word);
        }
        dfs(board, i+1, j, node, word);
        dfs(board, i-1, j, node, word);
        dfs(board, i, j+1, node, word);
        dfs(board, i, j-1, node, word);

        visit[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int rows = board.length, cols = board[0].length;
        visit = new boolean[rows][cols];
        result = new HashSet<>();

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                dfs(board, i, j, root, "");
            }
        }
        return new ArrayList<>(result);
    }
}
