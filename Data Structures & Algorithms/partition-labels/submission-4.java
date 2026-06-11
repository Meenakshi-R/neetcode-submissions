class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int end = 0, size = 0;
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        for(int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            end = Math.max(end, lastIndex.get(currentChar));
            size++;
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
