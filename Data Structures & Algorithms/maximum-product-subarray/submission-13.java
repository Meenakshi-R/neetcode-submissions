class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = 1, max = 1, result = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int temp = Math.min(nums[i], Math.min(min*nums[i], max*nums[i]));
            max = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            min = temp;

            result = Math.max(result, max);
        }
        return result;
    }
}
