class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                int sum = key+num;
                int neg = key-num;

                next.put(sum, next.getOrDefault(sum, 0) +value);
                next.put(neg, next.getOrDefault(neg, 0) +value);
            }
            count = next;
        }
        return count.getOrDefault(target, 0);
    }
}
