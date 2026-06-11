class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[n] = 1;

        for (int i=m-1; i>=0; i--) {
            int[] curr = new int[n+1];
            curr[n] = 1;
            
            for (int j=n-1; j>=0; j--) {
                curr[j] = dp[j];
                if (s.charAt(i) == t.charAt(j)) {
                    curr[j] += dp[j+1];
                }
            }
            dp = curr;
        }
        return dp[0];
    }
}
