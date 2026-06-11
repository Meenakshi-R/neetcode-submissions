class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currMin = 1, currMax = 1, result = nums[0];
        for (int num : nums) {
            int temp = num*currMax;
            currMax = Math.max(Math.max(temp, num*currMin), num);
            currMin = Math.min(Math.min(temp, num*currMin), num);
            result = Math.max(result, currMax);
        }
        return result;
    }
}
