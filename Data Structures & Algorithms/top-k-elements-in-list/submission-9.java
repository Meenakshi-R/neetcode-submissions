class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];
        Map<Integer, Integer> count = new HashMap<>();

        for (int i=0; i<n; i++) {
            count.merge(nums[i], 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int value = entry.getValue();
            int key = entry.getKey();

            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=bucket.length-1; i>=0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
