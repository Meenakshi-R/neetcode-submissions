class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> nextDP = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                int sum = key+num;
                int neg = key-num;

                nextDP.put(sum, nextDP.getOrDefault(sum, 0)+value);
                nextDP.put(neg, nextDP.getOrDefault(neg, 0)+value);
            }
            dp = nextDP;
        }
        return dp.getOrDefault(target, 0);
    }
}
