class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE, curr=0;
        for (int num: nums) {
            curr = Math.max(num, curr+num);
            max = Math.max(curr, max);
        }
        return max;
    }
}