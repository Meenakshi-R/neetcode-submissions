class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> subset) {
        if (i>=nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i+1, result, subset);
        subset.remove(subset.size()-1);
        dfs(nums, i+1, result, subset);
    }
}