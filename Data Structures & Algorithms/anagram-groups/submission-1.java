class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch-'a']++;
            }
            String keyWord = Arrays.toString(count);
            map.computeIfAbsent(keyWord, k->new ArrayList<>());
            map.get(keyWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
