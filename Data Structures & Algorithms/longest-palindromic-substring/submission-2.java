class Solution {
    public String longestPalindrome(String s) {
        int resIndex = 0, resLength = 0;
        int n = s.length();

        for (int i=0; i<n; i++) {
            int l = i;
            int r = i;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLength) {
                    resIndex = l;
                    resLength = r-l+1;
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > resLength) {
                    resIndex = l;
                    resLength = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIndex, resIndex+resLength);
    }
}
