class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int[] dp= new int[amount+1];
        dp[0]=1;
        
        for (int i=n-1; i>=0; i--) {
            for (int j = 0; j<=amount; j++) {
                dp[j] += (j-coins[i] >= 0) ? dp[j-coins[i]] : 0;
            }
        }
        return dp[amount];
    }
}