class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0, i=0;
        int n = nums.length;

        while (index < n) {
            nums[i] = nums[index];
            while (index<n && nums[i] == nums[index]) {
                index++;
            }
            i++;
        }
        return i;
    }
}