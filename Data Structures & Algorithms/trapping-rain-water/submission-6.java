class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int trappedArea = 0, leftMax = height[left], rightMax = height[right];

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trappedArea += (leftMax - height[left]);
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trappedArea += (rightMax - height[right]);
            }
        }
        return trappedArea;
    }
}