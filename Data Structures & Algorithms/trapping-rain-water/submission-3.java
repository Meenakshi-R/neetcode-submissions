class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int left=0, right=length-1;
        int leftMax = height[left], rightMax = height[right];
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
