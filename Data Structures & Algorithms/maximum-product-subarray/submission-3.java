class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, result = nums[0];

        for (int num : nums) {
            int temp = num * max;

            max = Math.max(num, Math.max(num*min, temp));
            min = Math.min(num, Math.min(num*min, temp));
            result = Math.max(result, max);
        }
        return result;
    }
}