class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int index=0, length = 0;
        
        for (int i=0; i<n; i++) {
            int l = i;
            int r = i;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > length) {
                    length = r-l+1;
                    index = l;
                }
                l--;
                r++;
            }
            l = i;
            r = i+1;
            while (l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > length) {
                    length = r-l+1;
                    index = l;
                }
                l--;
                r++;
            }
        }
        return length == 0 ? "" : s.substring(index, index+length);
    }
}
