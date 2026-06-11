class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0)
           return null;
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                indices[0] = map.get(difference);
                indices[1] = i;

                return indices;
            }
            map.put(nums[i], i);
        }
        return indices;
    }
}
