class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n-1, maxArea = Integer.MIN_VALUE;

        while (left < right) {
            if (heights[left] < heights[right]) {
                maxArea = Math.max(maxArea, heights[left]*(right-left));
                left++;
            }
            else {
                maxArea = Math.max(maxArea, heights[right]*(right-left));
                right--;
            }
        }
        return maxArea;
    }
}
