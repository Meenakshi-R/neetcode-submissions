class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
    
        for (int i=0; i<n; i++) {
            Map<Integer, Integer> next = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int value = entry.getValue();

                int sum = total + nums[i];
                int neg = total - nums[i];

                next.put(sum, next.getOrDefault(sum, 0)+value);
                next.put(neg, next.getOrDefault(neg, 0)+value);
            }
            dp = next;
        }
        return dp.getOrDefault(target, 0);
    }
}