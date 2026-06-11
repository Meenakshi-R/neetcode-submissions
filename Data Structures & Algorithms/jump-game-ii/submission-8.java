class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int right = 0, left = 0, jumps = 0;

        while (right < n-1) {
            int farthest = 0;
            for (int i=left; i<=right; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            jumps++;
            left = right+1;
            right = farthest;
        }
        return jumps;
    }
}
