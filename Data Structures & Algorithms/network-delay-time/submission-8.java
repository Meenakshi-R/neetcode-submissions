class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int src = time[0], dest = time[1], t = time[2];
            adjList.get(src).add(new int[]{dest, t});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, k});
        int totalTime = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[1], time = current[0];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            totalTime = time;

            for (int[] nei : adjList.get(node)) {
                int dest = nei[0], nextTime = nei[1];
                queue.offer(new int[]{nextTime+time, dest});
            }
        }
        return visited.size() == n ? totalTime : -1;
    }
}
