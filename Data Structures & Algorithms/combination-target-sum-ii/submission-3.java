class Solution {
    Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int target, int i, List<Integer> ds) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
        }
        if (target < 0 || i>=nums.length) {
            return;
        }
        ds.add(nums[i]);
        dfs(nums, target-nums[i], i+1, ds);
        ds.remove(ds.size()-1);
        dfs(nums, target, i+1, ds);
    }
}
