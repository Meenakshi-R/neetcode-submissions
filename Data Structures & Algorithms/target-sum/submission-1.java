class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDP = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                int sum = total+num;
                int neg = total-num;

                nextDP.put(sum, nextDP.getOrDefault(sum, 0)+ count);
                nextDP.put(neg, nextDP.getOrDefault(neg, 0)+ count);
            }
            dp = nextDP;
        }
        return dp.getOrDefault(target, 0);
    }
}