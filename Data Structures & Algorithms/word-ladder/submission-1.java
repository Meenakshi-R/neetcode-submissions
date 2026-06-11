class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
            String word = queue.poll();
            if (word.equals(endWord)) {
                return changes;
            }
            for (int j=0; j<word.length(); j++) {
                for (char ch = 'a'; ch<='z'; ch++) {
                    char[] arr = word.toCharArray();
                    arr[j] = ch;
                    String newWord = new String(arr);
                    if (wordList.contains(newWord) && !visited.contains(newWord)) {
                        queue.offer(newWord);
                        visited.add(newWord);
                    }
                }
            }
            }
            changes++;
        }
        return 0;
    }
}
