class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adjList.computeIfAbsent(ch, x -> new HashSet<>());
                indegree.put(ch, 0);
            }
        }
       
        for (int i=0; i<words.length-1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2)) {
                return "";
            }

            for (int j=0; j<minLen; j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);

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
        StringBuilder result = new StringBuilder();

        for (char key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            char ch = queue.poll();
            result.append(ch);

            for (char nei : adjList.get(ch)) {
                indegree.put(nei, indegree.get(nei)-1);
                if (indegree.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return result.toString().length() != adjList.size() ? "" : result.toString();
    }
}
