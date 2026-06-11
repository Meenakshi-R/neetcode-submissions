class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, result = nums[0];
        
        for (int num : nums) {
            int temp1 = num * min;
            int temp2 = num * max;

            min = Math.min(num, Math.min(temp1, temp2));
            max = Math.max(num, Math.max(temp1, temp2));

            result = Math.max(max, result);
        }
        return result;
    }
}
