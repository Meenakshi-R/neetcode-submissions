class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        queue.offer(new int[]{0, k});
        int delayTime = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int time = current[0], node = current[1];

            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            delayTime = time;
            if (adjList.containsKey(node)) {
            for (int[] edge : adjList.get(node)) {
                int target = edge[0];
                int newTime = edge[1];
                if (!visited.contains(target)) {
                    queue.offer(new int[]{time+newTime, target});
                }
            }
            }
        }
        return visited.size() == n ? delayTime : -1;
    }
}
