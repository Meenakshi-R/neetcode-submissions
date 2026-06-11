class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int length = s.length();
        int index = 0;
        int[] count = new int[26];

        while (index < length) {
            count[s.charAt(index) - 'a']++;
            count[t.charAt(index) - 'a']--;
            index++;
        }
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
