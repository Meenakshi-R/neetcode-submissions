class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> seen = new HashSet<>();
       int left = 0, right = 0, longest = 0;

        while(right < s.length())  {
            char ch = s.charAt(right);
            while (seen.contains(ch)) {
               seen.remove(s.charAt(left));
               left++;
            }
            seen.add(ch);
            longest = Math.max(longest, right-left+1);
            right++;
        }
       return longest;
    }
}