class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null && endWord == null) {
            return 0;
        }
        if (beginWord == null || endWord == null) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return changes;
                }
                for (int j=0; j<word.length(); j++) {
                    for (char c='a'; c<='z'; c++) {
                         char[] arr = word.toCharArray();
                         arr[j] = c;
                         String wordStr = new String(arr);
                         if (wordList.contains(wordStr) && !visited.contains(wordStr)) {
                              queue.add(wordStr);
                              visited.add(wordStr);
                         }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}
