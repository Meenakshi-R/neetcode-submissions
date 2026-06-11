class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for (int i=n-1; i>=0; i--) {
            for (String word : wordDict) {
                int length = word.length();
                if (i+length <= n && word.equals(s.substring(i, i+length))) {
                    dp[i] = dp[i] | dp[i+length];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
