class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        int left=0, right=0, longest=0, maxFreq=0;

        while (right < n) {
            char ch = s.charAt(right);
            freq.merge(ch, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(ch));

            while ((right-left+1)-maxFreq > k) {
                char leftChar = s.charAt(left);
                freq.merge(leftChar, -1, Integer::sum);
                left++;
            }
            right++;
            longest = Math.max(longest, right-left);
        }
        return longest;
    }
}
