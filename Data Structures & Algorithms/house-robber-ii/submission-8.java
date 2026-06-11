class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0], Math.max(helper(Arrays.copyOfRange(nums, 0, n-1)), 
                        helper(Arrays.copyOfRange(nums, 1, n))));
    }

    private int helper(int[] nums) {
        int n = nums.length;
        int prev1 =0, prev2 = 0;
        int result = 0;

        for (int i=0; i<n; i++) {
            result = Math.max(prev1+nums[i], prev2);
            prev1 = prev2;
            prev2 = result;
        }
        return Math.max(prev1, prev2);
    }
}
