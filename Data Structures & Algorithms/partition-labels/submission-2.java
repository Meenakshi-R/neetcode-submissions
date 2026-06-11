class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int end = 0, size = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            size++;
            end = Math.max(end, lastIndex.get(ch));

            if (i == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
