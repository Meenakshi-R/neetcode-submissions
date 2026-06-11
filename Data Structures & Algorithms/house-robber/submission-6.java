class Solution {
    public int rob(int[] nums) {
        int first = 0, second = 0;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            int result = Math.max(first+nums[i], second);
            first = second;
            second = result;
        }
        return second;
    }
}