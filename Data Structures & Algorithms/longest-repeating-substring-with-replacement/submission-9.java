class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, left = 0, right = 0, result = 0;
        Map<Character, Integer> count = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            count.put(ch, count.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, count.get(ch));

            while ((right-left+1)-maxFreq > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.getOrDefault(leftChar, 0)-1);
                left++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;
    }
}
