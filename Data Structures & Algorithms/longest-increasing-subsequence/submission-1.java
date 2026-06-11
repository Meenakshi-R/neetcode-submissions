class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if (result.get(result.size()-1) < nums[i]) {
                result.add(nums[i]);
            }
            else {
                int index = getLowerBound(result, nums[i]);
                result.set(index, nums[i]);
            }
        }
        return result.size();
    }

    private int getLowerBound(List<Integer> result, int num) {
        int left = 0, right = result.size()-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (result.get(mid) < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}