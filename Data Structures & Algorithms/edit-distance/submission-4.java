class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m < n) {
            return minDistance(word2, word1);
        }
        int[] dp = new int[n+1];
        for (int i=0; i<=n; i++) {
            dp[i] = n-i;
        }
        for (int i=m-1; i>=0; i--) {
            int[] curr = new int[n+1];
            curr[n] = m-i;

            for (int j=n-1; j>=0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    curr[j] = dp[j+1];
                }
                else {
                    curr[j] = 1 + Math.min(curr[j+1], Math.min(dp[j], dp[j+1]));
                }
            }
            dp = curr;
        }
        return dp[0];
    }
}
