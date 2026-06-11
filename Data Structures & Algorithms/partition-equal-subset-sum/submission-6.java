class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total%2 != 0) {
            return false;
        }
        int target = total/2;
        boolean[] dp = new boolean[target+1];
        dp[0]= true;

        for (int i=0; i<nums.length; i++) {
            for (int j=target; j>=0; j--) {
                if (j >= nums[i]) {
                   dp[j] = dp[j] | dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
