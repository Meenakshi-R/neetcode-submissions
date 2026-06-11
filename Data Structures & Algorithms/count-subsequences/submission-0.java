class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[n]=1;

        for (int i=m-1; i>=0; i--) {
            int prev = 1;
            for (int j=n-1; j>=0; j--) {
                int result = dp[j];
                if (s.charAt(i) == t.charAt(j)) {
                    result+=prev;
                }
                prev = dp[j];
                dp[j] = result;
            }
        }
        return dp[0];
    }
}
