class Solution {
    public int maxArea(int[] heights) {
        if(heights == null ||heights.length == 0)
           return 0;
        int left = 0, right = heights.length-1, maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(heights[left], heights[right]) * (right-left));
            if (heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}
