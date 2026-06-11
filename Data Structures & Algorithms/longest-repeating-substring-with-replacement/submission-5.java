class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
           return 0;
        }
        int left = 0, length = 0, maxFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFrequency = Math.max(maxFrequency, map.get(ch));

            while ((right-left+1)-maxFrequency > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            length = Math.max(length, right-left+1);
        }
        return length;
    }
}
