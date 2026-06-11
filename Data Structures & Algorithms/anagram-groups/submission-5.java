class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            anagrams.computeIfAbsent(key, x->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagrams.values());
    }
}
