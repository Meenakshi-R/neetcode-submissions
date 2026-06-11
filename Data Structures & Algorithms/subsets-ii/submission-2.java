class Solution {
    Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int i, List<Integer> ds) {
        if (i>=nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[i]);
        dfs(nums, i+1, ds);
        ds.remove(ds.size()-1);
        dfs(nums, i+1, ds);
    }
}
