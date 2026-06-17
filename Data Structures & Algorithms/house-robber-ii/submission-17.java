class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int result = Math.max(nums[0], Math.max(robUtil(Arrays.copyOfRange(nums, 0, n-1)), 
                              robUtil(Arrays.copyOfRange(nums,1, n))));

        return result;
    }

    private int robUtil(int[] nums) {
        int one = 0, two = 0, result=0;

        for (int i=0; i<nums.length; i++) {
            result = Math.max(two+nums[i], one);
            two = one;
            one = result;
        }
        return result;
    }
}
