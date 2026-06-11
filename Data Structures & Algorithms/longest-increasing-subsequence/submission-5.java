class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> LIS = new ArrayList<>();
        LIS.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if (LIS.get(LIS.size()-1) < nums[i]) {
                LIS.add(nums[i]);
                continue;
            }
            int index = getLowerBound(nums[i], LIS);
            LIS.set(index, nums[i]);
        }
        return LIS.size();
    }

    private int getLowerBound(int i, List<Integer> list) {
        int left = 0, right = list.size()-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (list.get(mid) < i) {
                left++;
            }
            else {
                right--;
            }
        }
        return left;
    }
}
