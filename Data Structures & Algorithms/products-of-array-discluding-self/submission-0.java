class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
           return null;
        int length = nums.length;
        int[] result = new int[length];

        result[0] = 1;
        for (int i=1; i<length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int next = 1;
        for (int right = length-1; right>=0; right--) {
            result[right] = next * result[right];
            next = next * nums[right];
        }
        return result;
    }
}  
