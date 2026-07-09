class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return "";
        }
        int startIndex = 0, minLength = Integer.MAX_VALUE;
        int left=0, right=0, counter=m;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        while (right < n) {
            char ch = s.charAt(right);
            if (map.get(ch) > 0) {
                counter--;
            }
            map.merge(ch, -1, Integer::sum);
            right++;

            while (counter == 0) {
                if(minLength > (right-left)) {
                    minLength = right-left;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                map.merge(leftChar, 1, Integer::sum);
                if (map.get(leftChar) > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minLength);
    }
}
