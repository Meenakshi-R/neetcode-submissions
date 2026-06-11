class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> LIS = new ArrayList<>();
        LIS.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if (nums[i] > LIS.get(LIS.size()-1)) {
                LIS.add(nums[i]);
            }
            else {
                int index = getLowerBound(LIS, nums[i]);
                LIS.set(index, nums[i]);
            }
        }
        return LIS.size();
    }

    private int getLowerBound(List<Integer> result, int num) {
        int left = 0, right = result.size()-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
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
