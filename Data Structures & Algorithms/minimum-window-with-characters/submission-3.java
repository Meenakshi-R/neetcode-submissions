class Solution {
    public String minWindow(String s, String t) {
        int right = 0, left = 0, counter = t.length(), start = 0, minLength = Integer.MAX_VALUE;
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : s.toCharArray()) {
            count.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0)+1);
        }

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (count.get(ch) > 0) {
                counter--;
            }
            count.put(ch, count.getOrDefault(ch, 0)-1);
            right++;
            while (counter == 0) {
                if (minLength > (right-left)) {
                    minLength = right-left;
                }
                char leftChar = s.charAt(left);
                count.put(leftChar, count.getOrDefault(leftChar, 0)+1);
                if (count.get(leftChar) > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(left-1, (left-1)+minLength);
    }
}
