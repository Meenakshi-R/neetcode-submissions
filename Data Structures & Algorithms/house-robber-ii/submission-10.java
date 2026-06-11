class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0], Math.max(helper(Arrays.copyOfRange(nums, 0, n-1)), 
                        helper(Arrays.copyOfRange(nums, 1, n))));
    }

    private int helper(int[] nums) {
        int first =0, second =0;
        int result =0;

        for (int i=0; i<nums.length; i++) {
            result = Math.max(first+nums[i], second);
            first = second;
            second = result;
        }
        return Math.max(first, second);
    }
}
