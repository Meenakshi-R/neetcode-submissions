class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length == 0) {
            return 0;
        }
        int n=nums.length;
        return Math.max(nums[0], 
                     Math.max(helper(Arrays.copyOfRange(nums, 1, n)), 
                              helper(Arrays.copyOfRange(nums, 0, n-1))));
    }

    private int helper(int[] nums) {
        int r1=0, r2=0;
        for (int num : nums) {
            int curr = Math.max(r1+num, r2);
            r1=r2;
            r2=curr;
        }
        return Math.max(r1, r2);
    }
}
