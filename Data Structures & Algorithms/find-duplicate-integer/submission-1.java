class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
           return -1;

        for (int num : nums) {
            int index = Math.abs(num)-1;
            if (nums[index] < 0)
               return Math.abs(num);
               
            nums[index] = nums[index]*(-1);
        }
        return -1;
    }
}
