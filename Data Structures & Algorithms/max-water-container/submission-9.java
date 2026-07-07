class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l=0, r=n-1;
        int max = Integer.MIN_VALUE;

        while (l < r) {
            if (heights[l] < heights[r]) {
                max = Math.max(max, heights[l] * (r-l));
                l++;
            }
            else {
                max = Math.max(max, heights[r] * (r-l));
                r--;
            }
        }
        return max;
    }
}
