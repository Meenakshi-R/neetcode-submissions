class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (char ch : s.toCharArray()) {
            freq.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }
        int left = 0, right = 0, counter = t.length();

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (freq.get(ch) > 0) {
                counter--;
            }
            freq.put(ch, freq.getOrDefault(ch, 0)-1);
            right++;
            while (counter == 0) {
                if (right-left < minLength) {
                    minLength = right-left;
                }
                freq.put(s.charAt(left), freq.getOrDefault(s.charAt(left), 0)+1);
                if (freq.get(s.charAt(left)) > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(left-1, (left-1)+minLength);
    }
}
