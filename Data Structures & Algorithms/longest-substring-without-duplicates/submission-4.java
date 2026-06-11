class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int longest = 0;

        for (char ch : s.toCharArray()) {
            while (set.contains(ch)) {
                set.remove(s.charAt(left++));
            }
            set.add(ch);
            longest = Math.max(longest, right-left+1);
            right++;
        }
        return longest;
    }
}
