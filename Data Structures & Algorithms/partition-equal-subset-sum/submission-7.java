class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;

        for (int i=0; i<n; i++) {
            for (int j=target; j>=0; j--) {
                if (j>=nums[i]) {
                   dp[j] = dp[j] | dp[j-nums[i]];
                }
            }
        }

        return dp[target];
    }
}
