class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> frequency = new HashMap<>();
        int maxFrequency = 0, result = 0;
        int left=0, length = s.length();

        for (int right = 0; right<length; right++) {
            char ch = s.charAt(right);
            frequency.put(ch, frequency.getOrDefault(ch, 0)+1);
            maxFrequency = Math.max(maxFrequency, frequency.get(ch));

            while ((right-left+1)-maxFrequency > k) {
                frequency.put(s.charAt(left), frequency.get(s.charAt(left))-1);
                left++;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
