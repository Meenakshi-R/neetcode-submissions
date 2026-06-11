class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for (Integer key : count.keySet()) {
            queue.offer(new int[]{count.get(key), key});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        int i=0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            result[i++] = current[1];
        }
        return result;
    }
}