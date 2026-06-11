class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
           return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, length = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right), right);
            length = Math.max(length, (right-left+1));
        }
        return length;
    }
}
