class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] product = new int[length];
        product[0] = 1;

        for (int i=1; i<length; i++) {
            product[i] = product[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i=nums.length-1; i>=0; i--) {
            product[i] *= right;
            right *= nums[i];
        }
        return product;
    }
}  
