class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> ds) {
        if (index >= nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if (target < 0) {
            return;
        }
        if (target >= nums[index]) {
            ds.add(nums[index]);
            dfs(nums, target-nums[index], index, ds);
            ds.remove(ds.size()-1);
        }
        dfs(nums, target, index+1, ds);
    }
}
