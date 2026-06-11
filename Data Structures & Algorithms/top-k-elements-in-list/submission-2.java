class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for (int i : count.keySet()) {
            int freq = count.get(i);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(i);
        }
        for (int i=bucket.length-1; i>=0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
     }
}
