class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m < n) {
           return minDistance(word2, word1);
        }
        int[] dp = new int[n+1];

        for (int i=0; i<=n; i++) {
            dp[i] = n-i;
        }
        for (int i=m-1; i>=0; i--) {
            int[] next = new int[n+1];
            next[n] = m-i;

            for (int j=n-1; j>=0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    next[j] =  dp[j+1];
                }
                else {
                    next[j] = 1+Math.min(dp[j], Math.min(next[j+1], dp[j+1]));
                }
            }
            dp = next;
        }
        return dp[0];
    }
}