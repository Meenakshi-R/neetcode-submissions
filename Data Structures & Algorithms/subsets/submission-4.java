class Solution {
    List<List<Integer>> subsets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return subsets;
    }

    private void dfs(int[] nums, int i, List<Integer> ds) {
        if (i>=nums.length) {
            subsets.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[i]);
        dfs(nums, i+1, ds);
        ds.remove(ds.size()-1);
        dfs(nums, i+1, ds);
    }
}
