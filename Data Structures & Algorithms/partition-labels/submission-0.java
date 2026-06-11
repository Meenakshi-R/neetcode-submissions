class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int size = 0, end = 0;
        for (int i=0; i<s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                 result.add(size);
                 size = 0;
            }
        }
        return result;
    }
}