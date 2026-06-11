class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        int[] dp = new int[n+1];
        dp[n] = 0;

        for (int i=m-1; i>=0; i--) {
            int[] next = new int[n+1];

            for (int j=n-1; j>=0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    next[j] = 1+dp[j+1];
                }
                else {
                    next[j] = Math.max(dp[j], next[j+1]);
                }
            }
            dp = next;
        }
        return dp[0];
    }
}
