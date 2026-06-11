class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1, maxArea = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                maxArea = Math.max((right-left)*heights[left], maxArea);
                left++;
            }
            else {
                maxArea = Math.max((right-left)*heights[right], maxArea);
                right--;
            }
        }
        return maxArea;
    }
}
