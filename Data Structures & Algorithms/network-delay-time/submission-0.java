class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], x->new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((a->a[0])));
        queue.offer(new int[]{0, k});
        int time = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int weight = current[0];
            int node = current[1];
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            time = weight;

            if (edges.containsKey(node)) {
                for (int[] edge : edges.get(node)) {
                    if (!visited.contains(edge[0])) {
                        queue.offer(new int[]{weight+edge[1], edge[0]});
                    }
                }
            }
        }
        return visited.size()==n ? time : -1;
    }
}
