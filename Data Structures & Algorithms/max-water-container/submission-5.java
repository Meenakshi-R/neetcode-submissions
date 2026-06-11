class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1, maxArea = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                maxArea = Math.max(maxArea, (right-left) * heights[left]);
                left++;
            }
            else {
                maxArea = Math.max(maxArea, (right-left) * heights[right]);
                right--;
            }
        }
        return maxArea;
    }
}
