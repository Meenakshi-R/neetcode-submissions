class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, current = 0;

        for (int num : nums) {
            current = Math.max(current+num, num);
            max = Math.max(max, current);
        }
        return max;
    }
}
