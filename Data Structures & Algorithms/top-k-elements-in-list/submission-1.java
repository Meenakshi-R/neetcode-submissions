class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for (Integer key : count.keySet()) {
            int frequency = count.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        for (int i=bucket.length-1; i>=0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
