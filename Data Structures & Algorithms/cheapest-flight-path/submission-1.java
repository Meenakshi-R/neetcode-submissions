class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int[] edge : flights) {
            edges.computeIfAbsent(edge[0], x->new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        } 
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int cheapest = element[0];
            int node = element[1];
            int stops = element[2];

            if (stops > k) {
                continue;
            }
            if (edges.containsKey(node)) {
                for (int[] edge : edges.get(node)) {
                    int nei = edge[0];
                    int nextCost = cheapest + edge[1];
                    if (nextCost < prices[nei]) {
                        prices[nei] = nextCost;
                        queue.offer(new int[]{nextCost, nei, stops+1});
                    }
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
