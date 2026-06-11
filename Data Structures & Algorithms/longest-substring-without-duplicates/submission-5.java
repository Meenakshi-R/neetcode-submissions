class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left=0, right=0, longest=0;

        for (int i=0; i<s.length(); i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(i));
            right++;
            longest = Math.max(longest, right-left);
        }
        return longest;
    }
}
