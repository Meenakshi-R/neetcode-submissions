class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], x->new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i=1; i<=n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(k, 0);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0], time = current[1];
            if (dist.get(node) < time) {
                continue;
            }
            if (adjList.containsKey(node)) {
                for (int[] nei : adjList.get(node)) {
                    int nextNode = nei[0], nextTime = nei[1];
                    if (time+nextTime < dist.get(nextNode)) {
                       dist.put(nextNode, time+nextTime);
                       queue.offer(new int[]{nextNode, time+nextTime});
                    }
                }
            }
        }
        int result = Collections.max(dist.values());
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}