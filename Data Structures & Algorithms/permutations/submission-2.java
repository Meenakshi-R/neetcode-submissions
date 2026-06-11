class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(0, nums, result);
        return result;
    }

    private void findPermutations(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int n : nums) {
                ds.add(n);
            }
            result.add(ds);
            return;
        }
        for (int i=index; i<nums.length; i++) {
            swap(i, index, nums);
            findPermutations(index+1, nums, result);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
    