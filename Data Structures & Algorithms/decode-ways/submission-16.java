class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp1=1, dp2=0, dp=0;

        for (int i=n-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                dp = 0;
            }
            else {
                dp = dp1;
                if (i+1 < n) {
                    int num = Integer.parseInt(s.substring(i, i+2));
                    if (num >=10 && num<=26) {
                       dp += dp2;
                    }
                }
            }
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }
}