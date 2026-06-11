class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int opt1 = 0, opt2 = 0, result = 0;

        for (int i=0; i<n; i++) {
            result = Math.max(opt1+nums[i], opt2);
            opt1 = opt2;
            opt2 = result;
        }
        return result;
    }
}