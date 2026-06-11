class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return changes;
                }

                for (int j=0; j<word.length(); j++) {
                    char[] wordArr = word.toCharArray();

                    for (char ch = 'a'; ch<='z'; ch++) {
                        wordArr[j] = ch;
                        String newWord = new String(wordArr);
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