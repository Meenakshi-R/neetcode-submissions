class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                edges.putIfAbsent(ch, new HashSet<>());
                indegree.put(ch, 0);
            }
        }
        for (int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.min(word1.length(), word2.length());

            if (word1.length() > word2.length() && word1.substring(0, len).equals(word2)) {
                return "";
            }
            for (int j=0; j<len; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    if (!edges.get(ch1).contains(ch2)) {
                        edges.get(ch1).add(ch2);
                        indegree.merge(ch2, 1, Integer::sum);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char node = queue.poll();
            result.append(node);

            for (char nei : edges.get(node)) {
                indegree.merge(nei, -1, Integer::sum);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return result.length() != edges.size() ? "" : result.toString();
    }
}
