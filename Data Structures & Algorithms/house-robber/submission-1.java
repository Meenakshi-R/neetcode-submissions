class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int first = 0, second = 0;
        for (int num : nums) {
            int curr = Math.max(num+first, second);
            first = second;
            second = curr;
        }
        return second;
    }
}
