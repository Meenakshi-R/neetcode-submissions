class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int first=nums[0], second=Math.max(nums[0], nums[1]);
        int result = Math.max(first, second);

        for (int i=2; i<n; i++) {
            result = Math.max(second, first+nums[i]);
            first = second;
            second = result;
        }
        return result;
    }
}
