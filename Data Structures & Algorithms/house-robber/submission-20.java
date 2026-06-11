class Solution {
    public int rob(int[] nums) {
        int one = 0, two = 0;

        for (int i=0; i<nums.length; i++) {
            int temp = Math.max(two+nums[i], one);
            two = one;
            one = temp;
        }
        return one;
    }
}
