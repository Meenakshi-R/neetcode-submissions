class Solution {
    public int jump(int[] nums) {
        int n = nums.length, jumps = 0, farthest = 0, left = 0, right = 0;

        while(right < n-1) { 
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
