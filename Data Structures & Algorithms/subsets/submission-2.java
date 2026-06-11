class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(0, nums, subsets, new ArrayList<>());
        return subsets;
    }

    private void findSubsets(int index, int[] nums, List<List<Integer>> subsets, List<Integer> ds) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        findSubsets(index+1, nums, subsets, ds);
        ds.remove(ds.size()-1);
        findSubsets(index+1, nums, subsets, ds);
    }
}