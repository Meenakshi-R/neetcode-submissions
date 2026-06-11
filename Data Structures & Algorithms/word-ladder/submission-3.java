class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        int changes = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return changes;
                }
                for (int j=0; j<word.length(); j++) {
                    for(char ch='a'; ch<='z'; ch++) {
                        char[] wordArr = word.toCharArray();
                        wordArr[j] = ch;
                        String newWord = new String(wordArr);

                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            changes++;
        }
        return 0;
    }
}