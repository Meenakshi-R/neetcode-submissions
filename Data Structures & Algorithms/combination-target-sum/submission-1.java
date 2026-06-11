class Solution {
    private void findCombinations(List<List<Integer>> result, List<Integer> ds, int[] nums,
                                  int target, int index) {
        if (target < 0) {
            return;
        }
        if (index == nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }          
        if (nums[index] <= target) {
            ds.add(nums[index]);
            findCombinations(result, ds, nums, target-nums[index], index);
            ds.remove(ds.size()-1);
        }                  
        findCombinations(result, ds, nums, target, index+1);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        findCombinations(result, new ArrayList<>(), nums, target, 0);
        return result;
    }
}
