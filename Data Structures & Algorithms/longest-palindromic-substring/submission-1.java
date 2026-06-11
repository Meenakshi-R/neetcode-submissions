class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resIndex = 0, resLen = 0;

        for (int i=0; i<n; i++) {
            int l=i, r=i;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLen) {
                    resIndex = l;
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
             while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLen) {
                    resIndex = l;
                    resLen = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIndex, resIndex+resLen);
    }
}