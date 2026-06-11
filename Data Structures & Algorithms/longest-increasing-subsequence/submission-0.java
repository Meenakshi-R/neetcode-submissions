class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (result.isEmpty() || result.get(result.size()-1) < num) {
                result.add(num);
            }
            else {
                int index = getLowerBound(result, num);
                result.set(index, num);
            }
        }
        return result.size();
    }

    private int getLowerBound(List<Integer> list, int num) {
        int left = 0, right = list.size()-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (list.get(mid) < num) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
