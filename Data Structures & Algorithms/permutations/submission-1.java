class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void findPermutations(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int n : nums) {
                ds.add(n);
            }
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index; i<nums.length; i++) {
            swap(i, index, nums);
            findPermutations(result, nums, index+1);
            swap(i, index, nums);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        findPermutations(result, nums, 0);
        return result;
    }
}
