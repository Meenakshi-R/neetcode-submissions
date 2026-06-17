class Solution {
    public int rob(int[] nums) {
        int one = 0, two = 0, result=0;

        for (int i=0; i<nums.length; i++) {
            result = Math.max(two+nums[i], one);
            two = one;
            one = result;
        }
        return result;
    }
}
