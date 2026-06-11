class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0) {
            return null;
        }
        int n = nums.length;
        int[] product = new int[n];
        product[0] = 1;

        for (int i=1; i<n; i++) {
            product[i] = product[i-1]*nums[i-1];
        }
        int next = 1;
        for (int right = n-1; right>=0; right--) {
            product[right] = product[right] * next;
            next = next * nums[right];
        }
        return product;
    }
}  
