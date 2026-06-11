class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length+1];

        for (int n : nums) {
             map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (bucket[value] == null) {
                  bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=bucket.length-1; i>0 && result.size()<k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
