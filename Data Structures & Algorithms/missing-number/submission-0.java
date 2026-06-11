class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = nums.length;
        for (int i=0; i<nums.length; i++) {
            result+=(i-nums[i]);
        }
        return result;
    }
}
