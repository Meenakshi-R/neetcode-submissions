class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> ds) {
        if (i>=nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if (nums[i] <= target) {
            ds.add(nums[i]);
            dfs(nums, target-nums[i], i, ds);
            ds.remove(ds.size()-1);
        }
        dfs(nums, target, i+1, ds);
    }
}
