class Solution {
    public String foreignDictionary(String[] words) {
      if (words == null || words.length == 0) {
        return null;
      }
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for (String word : words) {
        for (char ch : word.toCharArray()) {
            adj.putIfAbsent(ch, new HashSet<>());
            indegree.putIfAbsent(ch, 0);
        }
      }

      for (int i=0; i<words.length-1; i++) {
        String s1 = words[i];
        String s2 = words[i+1];
        int len = Math.min(s1.length(), s2.length());
        if (s1.length() > s2.length() && s1.substring(0, len).equals(s2.substring(0, len))) {
            return "";
        }
        for (int ptr = 0; ptr<len; ptr++) {
            if (s1.charAt(ptr) != s2.charAt(ptr)) {
               char index = s1.charAt(ptr);
               char value = s2.charAt(ptr);
               if (!adj.get(index).contains(value)) {
                      adj.get(index).add(value);
                      indegree.put(value, indegree.get(value)+1);
               }
               break;
            }
        }
      }
      Queue<Character> queue = new LinkedList<>();
      for (char edge : indegree.keySet()) {
        if (indegree.get(edge) == 0) {
            queue.add(edge);
        }
      }
      StringBuilder result = new StringBuilder();
      while (!queue.isEmpty()) {
        char ch = queue.poll();
        result.append(ch);
        for (Character nei : adj.get(ch)) {
            indegree.put(nei, indegree.get(nei)-1);
            if (indegree.get(nei) == 0) {
                queue.add(nei);
            }
        }
      }
      if (result.length() != indegree.size()) {
          return "";
      }      
      return result.toString();
    }
}
