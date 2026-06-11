class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        int startIndex = 0, minLength = Integer.MAX_VALUE;

        for (char ch : s.toCharArray()) {
            count.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0)+1);
        }
        int counter = t.length(), right = 0, left = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (count.getOrDefault(ch, 0) > 0) {
                counter--;
            }
            count.put(ch, count.getOrDefault(ch, 0)-1);
            right++;
            while (counter == 0) {
                if ((right-left) < minLength) {
                    minLength = right-left;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                count.put(leftChar, count.getOrDefault(leftChar, 0)+1);
                if (count.getOrDefault(leftChar, 0) > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minLength);
    }
}
