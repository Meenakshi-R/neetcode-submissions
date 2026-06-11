class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(0, nums, subsets, new ArrayList<>());
        return subsets;
    }

    private void findSubsets(int index, int[] nums, List<List<Integer>> subsets, List<Integer> ds) {
        subsets.add(new ArrayList<>(ds));
       
        for (int i=index; i<nums.length; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            ds.add(nums[i]);
            findSubsets(i+1, nums, subsets, ds);
            ds.remove(ds.size()-1);
        }
    }
}