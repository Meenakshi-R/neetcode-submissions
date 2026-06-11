class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n != s3.length()) {
            return false;
        }
        if (n < m) {
            String temp1 = s1;
            s1 = s2;
            s2 = temp1;
            int length = m;
            m = n;
            n = length;
        }
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for (int i=m; i>=0; i--) {
            boolean[] next = new boolean[n+1];
            next[n] = true;

            for (int j=n; j>=0; j--) {
                if (i<m && s1.charAt(i) == s3.charAt(i+j) && dp[j]) {
                    next[j] = true;
                }
                if (j<n && s2.charAt(j) == s3.charAt(i+j) && next[j+1]) {
                    next[j] = true;
                }
            }
            dp = next;
        }
        return dp[0];
    }
}