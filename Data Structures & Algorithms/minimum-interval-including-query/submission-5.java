class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] queriesCopy = queries.clone();
        Arrays.sort(queriesCopy);
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int index = 0;

        for (int query : queriesCopy) {

            while (index < intervals.length && intervals[index][0] <= query) {
                int start = intervals[index][0];
                int end = intervals[index][1];

                queue.offer(new int[]{end-start+1, end});
                index++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < query) {
                queue.poll();
            }
            map.put(query, queue.isEmpty() ? -1 : queue.peek()[0]);
        }
        int[] result = new int[queries.length];
        index = 0;

        for (int query : queries) {
            result[index++] = map.get(query);
        }
        return result;
    }
}