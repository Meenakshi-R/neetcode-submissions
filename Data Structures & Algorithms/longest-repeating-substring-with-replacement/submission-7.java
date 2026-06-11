class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int maxFreq = 0, result = 0, left = 0;

        for (int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);

            maxFreq = Math.max(maxFreq, freq.get(ch));

            while ((right-left+1)-maxFreq > k) {
                freq.put(s.charAt(left), freq.getOrDefault(s.charAt(left), 0)-1);
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}