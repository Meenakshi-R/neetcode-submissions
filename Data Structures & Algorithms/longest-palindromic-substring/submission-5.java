class Solution {
    public String longestPalindrome(String s) {
        int length = 0, index = 0;
        int n = s.length();

        for (int i=0; i<n; i++) {
            int left=i, right=i;
            while (left>=0 && right<n && s.charAt(left) == s.charAt(right)) {
                if (right-left+1 > length) {
                    length = right-left+1;
                    index = left;
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while (left>=0 && right<n && s.charAt(left) == s.charAt(right)) {
                if (length < right-left+1) {
                    length = right-left+1;
                    index = left;
                }
                left--;
                right++;
            }
        }
        return length == 0 ? "" : s.substring(index, index+length);
    }
}
