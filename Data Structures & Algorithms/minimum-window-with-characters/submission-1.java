class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, 0);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int left =0, right = 0, counter = t.length(), minLength = Integer.MAX_VALUE;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (map.get(ch) > 0) {
                counter--;
            }
            map.put(ch, map.getOrDefault(ch, 0)-1);
            right++;
            while (counter == 0) {
                if (minLength > (right-left)) {
                    minLength = right-left;
                }
                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0)+1);
                if (map.getOrDefault(leftChar, 0) > 0) {
                    counter++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(left-1, (left-1)+minLength);
    }
}
