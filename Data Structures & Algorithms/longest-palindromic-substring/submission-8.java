class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;
        int length = 0, startIndex = 0, i=0;

        while (i<n) {
            left = i;
            right = i;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)) {
                if (length < right-left+1) {
                    length = right-left+1;
                    startIndex = left;
                }
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)) {
                if (length < right-left+1) {
                    length = right-left+1;
                    startIndex = left;
                }
                right++;
                left--;
            }
            i++;
        }
        return length == 0 ? "" : s.substring(startIndex, startIndex+length);
    }
}
