class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i=0; i<length-2; i++) {
           int j=i+1;
           int k=length-1;

           while (j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum == 0) {
                  result.add(List.of(nums[i], nums[j++], nums[k--]));
                }
                else if (sum < 0) {
                  j++;
                }
                else {
                  k--;
                }
           }
        }
        return new ArrayList<>(result);
    }
}
