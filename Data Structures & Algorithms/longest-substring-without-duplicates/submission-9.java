class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int longest = 0, left=0, right=0;

        while (right < n) {
            char ch = s.charAt(right);

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            longest = Math.max(longest, right-left);
        }
        return longest;
    }
}
