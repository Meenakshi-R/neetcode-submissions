class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int target, int i, List<List<Integer>> result, List<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }        
        if (target < 0 || i>= nums.length) {
            return;
        }
        combination.add(nums[i]);
        dfs(nums, target-nums[i], i, result, combination);
        combination.remove(combination.size()-1);
        dfs(nums, target, i+1, result, combination);
    }
}