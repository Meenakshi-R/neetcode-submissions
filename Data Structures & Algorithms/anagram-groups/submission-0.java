class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }
            String keyWord = Arrays.toString(count);
            map.putIfAbsent(keyWord, new ArrayList<>());
            map.get(keyWord).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
