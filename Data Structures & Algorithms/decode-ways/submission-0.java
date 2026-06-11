class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.startsWith("0")) {
            return 0;
        }
        int curr =0, first = 1, second = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                curr = 0;
            }
            else {
                curr = first;
                if (i+1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && 
                                         s.charAt(i+1) < '7')) {
                    
                    curr+=second;
                }
            }
            second = first;
            first = curr;
            curr=0;
        }
        return first;
    }
}
