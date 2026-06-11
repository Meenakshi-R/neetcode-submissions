class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        prefix[0] = 1;

        for (int i=1; i<length; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i=length-1; i>=0; i--) {
            prefix[i] = prefix[i]*right;
            right = right*nums[i];
        }
        return prefix;
    }
}  