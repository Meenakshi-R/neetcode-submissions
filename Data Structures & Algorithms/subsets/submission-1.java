class Solution {
    private void findSubsets(List<List<Integer>> result, List<Integer> ds, int[] nums, int index) {
         if (index >= nums.length) {
              result.add(new ArrayList<>(ds));
              return;
         }
         findSubsets(result, ds, nums, index+1);
         ds.add(nums[index]);
         findSubsets(result, ds, nums, index+1);
         ds.remove(ds.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        findSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }
}
