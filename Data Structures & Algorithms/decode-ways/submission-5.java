class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int next1 = 1, next2 = 0, curr = 0;

        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                curr = 0;
            }
            else {
               curr = next1;
                if (i+1 < s.length() && (s.charAt(i) == '1' || 
                    (s.charAt(i) == '2' && s.charAt(i+1) < '7'))) {
                  curr += next2;
                }
            }
            next2 = next1;
            next1 = curr;
            curr = 0;
        }
        return next1;
    }
}