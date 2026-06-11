class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0], Math.max(helper(Arrays.copyOfRange(nums, 0, n-1)), 
                                    helper(Arrays.copyOfRange(nums, 1, n))));
    }

    private int helper(int[] nums) {
        int one = 0, two = 0;

        for (int i=0; i<nums.length; i++) {
            int temp = Math.max(two+nums[i], one);
            two = one;
            one = temp;
        }
        return one;
    }
}
