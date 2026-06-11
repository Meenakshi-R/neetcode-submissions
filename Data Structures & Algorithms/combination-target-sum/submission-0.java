class Solution {
    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int index, 
                            int[] nums, int target) {                    
            if (target == 0) {
                result.add(new ArrayList<>(tempList));
                return;
            }          
            if (target<0 || index >= nums.length) {
                return;
            }          
            if (nums[index] <= target) {
                tempList.add(nums[index]);
                backTrack(result, tempList, index, nums, target-nums[index]);
                tempList.remove(tempList.size()-1);
            }
            backTrack(result, tempList, index+1, nums, target);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        backTrack(result, new ArrayList<>(), 0, nums, target);
        return result;
    }
}
