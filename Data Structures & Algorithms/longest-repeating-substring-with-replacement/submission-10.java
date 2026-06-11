class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, n = s.length(), longest = 0, maxFreq = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            count.put(ch, count.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, count.get(ch));

            while ((right-left+1)-maxFreq > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.getOrDefault(leftChar, 0)-1);
                left++;
            }
            longest = Math.max(longest, right-left+1);
        }
        return longest;
    }
}