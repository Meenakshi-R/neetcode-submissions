class Trie {
    Map<Character, Trie> children = new HashMap<>();
    boolean endOfWord;
}

class PrefixTree {

    Trie root = new Trie();

    public PrefixTree() {
    }

    public void insert(String word) {
        Trie current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new Trie());
            current = current.children.get(ch);
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        Trie current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = root;
        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return true;
    }
}
