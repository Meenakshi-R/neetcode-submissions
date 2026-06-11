class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, result = nums[0];

        for (int num : nums) {
            int temp = max*num;
            max = Math.max(num, Math.max(temp, min*num));
            min = Math.min(num, Math.min(min*num, temp));
            result = Math.max(result, max);
        }
        return result;
    }
}
