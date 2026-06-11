class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        int[] queryCopy = queries.clone();
        Arrays.sort(queryCopy);

        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        int index = 0;

        for (int i=0; i<queryCopy.length; i++) {
            while (index < intervals.length && intervals[index][0] <= queryCopy[i]) {
                int start = intervals[index][0];
                int end = intervals[index][1];

                queue.offer(new int[]{(end-start+1), end});
                index++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < queryCopy[i]) {
                queue.poll();
            }
            result.put(queryCopy[i], queue.isEmpty() ? -1 : queue.peek()[0]);
        }
        int[] answer = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            answer[i] = result.get(queries[i]);
        }
        return answer;
    }
}
