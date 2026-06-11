class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if(nums[i] > result.get(result.size()-1)) {
                result.add(nums[i]);
            }
            else {
                int lowerBound = getLowerBound(nums[i], result);
                result.set(lowerBound, nums[i]);
            }
        }
        return result.size();
    }

    private int getLowerBound(int num, List<Integer> result) {
        int left = 0, right = result.size()-1;

        while (left <= right) {
            int mid = left+(right-left)/2;
            if (result.get(mid) < num) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return left;
    }
}
