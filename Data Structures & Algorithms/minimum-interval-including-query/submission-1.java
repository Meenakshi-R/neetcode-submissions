class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        if (intervals == null || intervals.length == 0) {
               return new int[]{};
        }
        if (queries == null || queries.length == 0) {
            return queries;
        }
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        int[] queriesCopy = queries.clone();
        Arrays.sort(queriesCopy);
        Map<Integer, Integer> resultMap = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int index = 0;

        for (int query : queriesCopy) {
            while(index < intervals.length && intervals[index][0] <= query) {
                int l = intervals[index][0];
                int r = intervals[index][1];

                queue.offer(new int[]{r-l+1, r});
                index++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < query) {
                queue.poll();
            }
            resultMap.put(query, queue.isEmpty() ? -1 : queue.peek()[0]);
        }
        int[] result = new int[queries.length];
        int i=0;
        for (int query : queries) {
            result[i++] = resultMap.get(query);
        }
        return result;
    }
}
