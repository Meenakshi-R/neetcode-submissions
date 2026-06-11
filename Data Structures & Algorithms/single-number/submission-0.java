class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null ||nums.length == 0) {
            return -1;
        }
        int xor = 0;
        for (int num : nums) {
            xor^=num;
        }
        return xor;
    }
}
