class Solution {
    public int maxProduct(int[] nums) {
        int minProduct = 1, maxProduct = 1, result = nums[0];

        for (int num : nums) {
            int temp = num*minProduct;
            minProduct = Math.min(num, Math.min(temp, num*maxProduct));
            maxProduct = Math.max(num, Math.max(temp, num*maxProduct));

            result = Math.max(maxProduct, result);
        }
        return result;
    }
}
