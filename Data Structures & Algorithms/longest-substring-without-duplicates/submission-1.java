class Solution {
    public int lengthOfLongestSubstring(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }
       Set<Character> set = new HashSet<>();
       int left = 0, right = 0, length = 0;

       while (right < s.length()) {
           while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
           }
           set.add(s.charAt(right));
           length = Math.max(length, right-left+1);
           right++;
       }
       return length;
    }
}
