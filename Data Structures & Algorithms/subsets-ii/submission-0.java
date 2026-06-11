class Solution {
    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int index) {
         result.add(new ArrayList<>(tempList));
        
         for (int i=index; i<nums.length; i++) {
             if (i>index && nums[i] == nums[i-1]) {
                  continue;
             }
             tempList.add(nums[i]);
             backTrack(result, tempList, nums, i+1);
             tempList.remove(tempList.size()-1);
         }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
}
