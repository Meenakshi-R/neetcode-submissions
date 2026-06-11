class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i=0; i<=n; i++) {
            while (!stack.isEmpty() && (i==n || heights[stack.peek()] >= heights[i])) {
                    int height = heights[stack.pop()];
                    int width = stack.isEmpty() ? i : i-stack.peek()-1;
                    maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
