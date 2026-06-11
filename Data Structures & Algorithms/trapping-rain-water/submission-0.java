class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
             return 0;
        }
        int left = 0, right = height.length-1;
        int leftMax = height[0], rightMax = height[height.length-1];
        int trappedArea = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedArea += leftMax-height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedArea += rightMax-height[right];
            }
        }
        return trappedArea;
    }
}
