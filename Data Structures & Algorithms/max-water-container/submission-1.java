class Solution {
    public int maxArea(int[] heights) {
       if (heights == null || heights.length == 0) {
          return 0;
       }
       int left = 0, right = heights.length-1;
       int minHeight = Integer.MAX_VALUE, maxArea = Integer.MIN_VALUE;

       while (left < right) {
            minHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, minHeight*(right-left));
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
