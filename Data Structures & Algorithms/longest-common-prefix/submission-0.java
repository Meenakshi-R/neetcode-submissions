class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
}

class Trie {
    public TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
    }

    public int lcp(String word, int prefixLen) {
        int j=0;
        TrieNode curr = root;
        int len = Math.min(word.length(), prefixLen);

        while (j < len) {
            if (!curr.children.containsKey(word.charAt(j))) {
                return j;
            }
            curr = curr.children.get(word.charAt(j));
            j++;
        }
        return len;
    }
}
    
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        int mini = 0;

        for (int i=1; i<strs.length; i++) {
            if (strs[i].length() < strs[mini].length()) {
                mini = i;
            }
        }
        trie.insert(strs[mini]);
        int prefixLen = strs[mini].length();

        for (String str : strs) {
            prefixLen = trie.lcp(str, prefixLen);
        }
        return strs[0].substring(0, prefixLen);
    }
}