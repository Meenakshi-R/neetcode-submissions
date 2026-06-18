class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2 != 0) {
            return false;
        }
        int n = nums.length;
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for (int i=n-1; i>=0; i--) {
            for (int j=target; j>=nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}