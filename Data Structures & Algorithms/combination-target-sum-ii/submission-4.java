class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, target, 0, result, new ArrayList<>(), 0);

        return result;
    }

    private void dfs(int[] nums, int target, int i, List<List<Integer>> result, List<Integer> path, int total) {
        if (total == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (i>=nums.length) {
            return;
        }
        for (int index = i; index<nums.length; index++) {
            if (index > i && nums[index] == nums[index-1]) {
                continue;
            }
            if (total + nums[index] > target) {
                break;
            }
            path.add(nums[index]);
            dfs(nums, target, index+1, result, path, total+nums[index]);
            path.remove(path.size()-1);
        }
    }
}