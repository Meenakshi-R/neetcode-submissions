class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSum = nums[0];
        for (int n : nums) {
            currentSum = Math.max(currentSum+n, n);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}