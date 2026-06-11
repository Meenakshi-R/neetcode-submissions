class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int currentMax = 0, maxSum = nums[0];
        for (int num : nums) {
            if (currentMax < 0) {
                currentMax = 0;
            }
            currentMax += num;
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }
}
