class Solution {
    private void backTrack(List<List<Integer>> result, List<Integer> tempList, boolean[] pick, 
                           int[] nums) {
           if (tempList.size() == nums.length) {
               result.add(new ArrayList<>(tempList));
               return;
           }  
           for (int i=0; i<nums.length; i++) {       
             if (!pick[i]) {
                  tempList.add(nums[i]);
                  pick[i] = true;
                  backTrack(result, tempList, pick, nums);
                  tempList.remove(tempList.size()-1);
                  pick[i] = false;
             }
           }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] pick = new boolean[nums.length];
        backTrack(result, new ArrayList<>(), pick, nums);
        return result;
    }
}
