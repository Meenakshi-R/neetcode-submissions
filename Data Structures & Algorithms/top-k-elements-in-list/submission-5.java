class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        for (Integer key : countMap.keySet()) {
            if (bucket[countMap.get(key)] == null) {
                bucket[countMap.get(key)] = new ArrayList<>();
            }
            bucket[countMap.get(key)].add(key);
        }
        int index =0;
        List<Integer> result = new ArrayList<>();

        for (int i=bucket.length-1; i>=0 && result.size()<k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}