class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1, trappedArea = 0;
        int leftMax= height[left], rightMax = height[right];

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
