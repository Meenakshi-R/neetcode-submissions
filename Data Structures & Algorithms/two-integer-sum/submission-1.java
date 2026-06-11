class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums==null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if(indices.containsKey(target-nums[i])) {
                result[0] = indices.get(target-nums[i]);
                result[1] = i;

                return result;
            }
            indices.put(nums[i], i);
        }
        return result;
    }
}
