class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], x-> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        queue.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int time = 0;

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int weight = element[0];
            int node = element[1];
            if(visited.contains(node)) {
                continue;
            }
            visited.add(node);
            time = weight;
            if (edges.containsKey(node)) {
              for (int[] edge : edges.get(node)) {
                int next = edge[0], nextCost = edge[1];
                if (!visited.contains(next)) {
                    queue.offer(new int[]{time+nextCost, next});
                }
              }
            }
        }
        return visited.size() == n ? time : -1;
    }
}
