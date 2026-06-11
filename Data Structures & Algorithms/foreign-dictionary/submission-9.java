class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> wordsMap = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (int i=0; i<words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                wordsMap.computeIfAbsent(ch, x->new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }
        for (int i=0; i<words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];

            int length = Math.min(s1.length(), s2.length());
            if (s1.length() > s2.length() && s1.substring(0, length).equals(s2)) {
                return "";
            }

            for (int j=0; j<length; j++) {
                char ch1 = s1.charAt(j);
                char ch2 = s2.charAt(j);

                if (ch1 != ch2) {
                    if (!wordsMap.get(ch1).contains(ch2)) {
                       wordsMap.get(ch1).add(ch2);
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

            for (char ch : wordsMap.get(current)) {
                indegree.put(ch, indegree.get(ch)-1);
                if (indegree.get(ch) == 0) {
                    queue.offer(ch);
                }
            }
        }
        return indegree.size() == result.length() ? result.toString() : "";
    }
}