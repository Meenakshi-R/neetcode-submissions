class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int size = 0, maxEnd = 0;
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            size++;
            maxEnd = Math.max(maxEnd, lastIndex.get(s.charAt(i)));

            if (i == maxEnd) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}