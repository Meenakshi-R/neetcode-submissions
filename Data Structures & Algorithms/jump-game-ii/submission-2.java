class Solution {
    public int jump(int[] nums) {
        int left = 0, right = 0, farthest = 0, jumps = 0;
        while (right < nums.length-1) {
            farthest = 0;
            for (int i=left; i<=right; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            left = right+1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}
