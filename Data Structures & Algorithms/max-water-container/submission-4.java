class Solution {
    public int maxArea(int[] heights) {
        int length = heights.length;
        int left=0, right = length-1, maxArea = 0;

        while (left < right) {
            if (heights[left] <= heights[right]) {
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
