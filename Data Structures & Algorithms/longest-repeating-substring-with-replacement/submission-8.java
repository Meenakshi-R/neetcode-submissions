class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int maxFreq = 0, result = 0, left = 0;

        for (int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);
            count.put(ch, count.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, count.get(ch));

            while ((right-left+1)-maxFreq > k) {
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar)-1);
                left++;
            }
            result = Math.max(result, (right-left+1));
        }
        return result;
    }
}
