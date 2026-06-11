class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);
        int result = Math.max(prev1, prev2);
    
        for (int i=2; i<n; i++) {
           result = Math.max(prev1, prev2+nums[i]);
           prev2 = prev1;
           prev1 = result;
        }
        return result;
    }
}