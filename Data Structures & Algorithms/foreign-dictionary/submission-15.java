class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                edges.computeIfAbsent(ch, x-> new HashSet());
                indegree.put(ch, 0);
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
                    if (!edges.get(ch1).contains(ch2)) {
                        edges.get(ch1).add(ch2);
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

            for (char ch : edges.get(current)) {
                indegree.put(ch, indegree.get(ch)-1);
                if (indegree.get(ch) == 0) {
                    queue.offer(ch);
                }
            }
        }
        return result.length() == indegree.size() ? result.toString() : "";
    }
}
