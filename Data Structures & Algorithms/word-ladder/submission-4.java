class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int changes = 1;
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                   return changes;
                }
                for (int j=0; j<currentWord.length(); j++) {
                   char[] wordArr = currentWord.toCharArray();

                    for (char ch = 'a'; ch<='z'; ch++) {
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
