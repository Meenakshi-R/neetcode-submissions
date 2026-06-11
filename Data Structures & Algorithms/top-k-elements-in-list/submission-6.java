class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for (int num : nums) {
          count.put(num, count.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=bucket.length-1; i>=0 && result.size()<k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
