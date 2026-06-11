class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
             return 0;
        }
        int l = 0, r = 0, farthest = 0, jumps = 0;
        while (r < nums.length-1) {
            farthest = 0;
            for (int i=l; i<=r; i++) {
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r+1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}
