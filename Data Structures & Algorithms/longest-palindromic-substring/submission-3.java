class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int length = 0, index = 0;

        for (int i=0; i<n; i++) {
            int left = i;
            int right = i;
            while (left>=0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right-left+1 > length) {
                    index = left;
                    length = right-left+1;
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while (left>=0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right-left+1 > length) {
                    index = left;
                    length = right-left+1;
                }
                left--;
                right++;
            }
        }
        return s.substring(index, index+length);
    }
}
