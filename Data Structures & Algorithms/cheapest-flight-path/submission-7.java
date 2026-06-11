class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for (int[] flight : flights) {
            edges.computeIfAbsent(flight[0], x->new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int price = current[0], node = current[1], stops = current[2];

            if (stops > k) {
                continue;
            }
            if (edges.containsKey(node)) {
                for (int[] next : edges.get(node)) {
                    int nextNode = next[0], nextPrice = next[1];

                    if (dist[nextNode] > nextPrice+price) {
                        queue.offer(new int[]{nextPrice+price, nextNode, stops+1});
                        dist[nextNode] = nextPrice + price;
                    }
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}