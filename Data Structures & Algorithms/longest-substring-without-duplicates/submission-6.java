class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0,longest = 0;

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            right++;
            longest = Math.max(longest, (right-left));
            set.add(ch);
        }
        return longest;
    }
}
