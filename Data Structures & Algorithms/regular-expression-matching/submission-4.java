class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for (int i=m; i>=0; i--) {
            boolean[] curr = new boolean[n+1];
            curr[n] = i==m;

            for (int j=n-1; j>=0; j--) {
                boolean match = i<m && ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.');
                if (j+1 < n && p.charAt(j+1) == '*') {
                    curr[j] = curr[j+2];
                    if (match) {
                        curr[j] = dp[j] || curr[j];
                    }
                }
                else if (match) {
                   curr[j] = dp[j+1];
                }
            }
            dp = curr;
        }
        return dp[0];
    }
}