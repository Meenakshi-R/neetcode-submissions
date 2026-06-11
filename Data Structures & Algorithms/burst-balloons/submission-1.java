class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] clone = new int[length+2];

        System.arraycopy(nums, 0, clone, 1, length);
        clone[0] = 1;
        clone[clone.length-1] = 1;

        int[][] dp = new int[length+2][length+2];

        for (int i=length; i>=1; i--) {
            for (int j=1; j<=length; j++) {
                if (i > j) {
                    continue;
                }
                int max = Integer.MIN_VALUE;

                for (int index=i; index<=j; index++) {
                   int coins = clone[i-1]*clone[index]*clone[j+1] + dp[i][index-1] + dp[index+1][j];
                   max = Math.max(max, coins);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][length];
    }
}
