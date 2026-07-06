class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        int sum = 0, result = 0;

        for (int num : nums) {
            sum += num;

            if (sum == k) {
                result++;
            }
            if (count.containsKey(sum-k)) {
                result += count.get(sum-k);
            }
            count.merge(sum, 1, Integer::sum);
        }
        return result;
    }
}