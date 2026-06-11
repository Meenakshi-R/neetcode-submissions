class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for(char ch : word.toCharArray()) {
                adjList.computeIfAbsent(ch, x->new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        for (int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int minLen = Math.min(word1.length(), word2.length());
            if (word1.length() > word2.length() && word1.substring(0, minLen).equals(word2)) {
                return "";
            }

            for (int j=0; j<minLen; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);

                if (ch1 != ch2) {
                    if (!adjList.get(ch1).contains(ch2)) {
                        adjList.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2)+1);
                    }
                    break;
            }
           }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.offer(ch);
            }
        }
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            if (!adjList.get(current).isEmpty()) {
                for (char next : adjList.get(current)) {
                    indegree.put(next, indegree.get(next)-1);
                    if (indegree.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
    return indegree.size() == result.length() ? result.toString() : "";
    }
}