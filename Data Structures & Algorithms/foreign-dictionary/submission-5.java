class Solution {
    public String foreignDictionary(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        int N = words.length;
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                adj.computeIfAbsent(ch, k->new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        for (int i=0; i<N-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());

            if (s1.length() > s2.length() && s1.substring(0, len).equals(s2)) {
                return "";
            }
            for (int j=0; j<len; j++) {
                char index = s1.charAt(j);
                char value = s2.charAt(j);
                if (index != value) {
                    if (!adj.get(index).contains(value)) {
                      adj.get(index).add(value);
                      indegree.put(value, indegree.get(value)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                queue.add(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!queue.isEmpty()) {
            char ch = queue.poll();
            result.append(ch);

            for (char nei : adj.get(ch)) {
                indegree.put(nei, indegree.get(nei)-1);
                if (indegree.get(nei) == 0) {
                    queue.add(nei);
                }
            }
        }
        return indegree.size() == result.length() ? result.toString() : "";
    }
}
