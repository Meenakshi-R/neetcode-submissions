class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();

        for (char ch : s.toCharArray()) {
            count.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0)+1);
        }
        int counter = t.length(), left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, startIndex = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (count.get(ch) > 0) {
                counter--;
            }
            count.put(ch, count.getOrDefault(ch, 0)-1);
            right++;

            while (counter == 0) {
                if ((right-left) < minLen) {
                    minLen = right-left;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                count.put(leftChar, count.get(leftChar)+1);
                if (count.get(leftChar) > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minLen);

    }
}
