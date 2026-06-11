class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean endOfWord;
}

class WordDictionary {

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie current = root;

        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new Trie());
            current = current.children.get(ch);
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        Trie current = root;
        return dfs(word, 0, current);
    }

    private boolean dfs(String word, int index, Trie current) {
       for (int i=index; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Trie child : current.children.values()) {
                    if (child != null && dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            }
            else if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.endOfWord;
    }
}
