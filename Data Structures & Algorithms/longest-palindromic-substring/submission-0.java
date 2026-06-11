class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int index=0, length=0;
        for (int i=0; i<s.length(); i++) {
            int l=i, r=i;
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > length) {
                    index = l;
                    length = r-l+1;
                }
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > length) {
                    index = l;
                    length = r-l+1;
                }
                l--;
                r++;
            }
        }
        return s.substring(index, index+length);
    }
}
