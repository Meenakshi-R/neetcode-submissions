class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int start = 0, end = 0, minLength = Integer.MAX_VALUE, counter = t.length();

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (map.get(ch) > 0) {
                 counter--;
            }
            map.put(ch, map.getOrDefault(ch, 0)-1);
            end++;

            while (counter == 0) {
                if (minLength > end-start) {
                    minLength = end-start;
                }
                char leftChar = s.charAt(start);
                map.put(leftChar, map.getOrDefault(leftChar, 0)+1);
                if (map.get(leftChar) > 0) {
                     counter++;
                }
                start++;
            }
        } 
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start-1, (start-1)+minLength);
    }
}
