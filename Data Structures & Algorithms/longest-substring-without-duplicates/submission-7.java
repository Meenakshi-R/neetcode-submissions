class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> visited = new HashSet<>();
        int longest = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            while(visited.contains(s.charAt(right))) {
                visited.remove(s.charAt(left));
                left++;
            }
            visited.add(s.charAt(right));
            longest = Math.max(longest, (right-left)+1);
            right++;
        }
        return longest;
    }
}
