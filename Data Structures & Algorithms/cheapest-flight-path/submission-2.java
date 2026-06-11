class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights == null || flights.length == 0) {
            return 0;
        }
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for (int[] flight : flights) {
            edges.computeIfAbsent(flight[0], x->new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});
        price[src] = 0;

        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int cost = element[0], node = element[1], stops = element[2];

            if (stops > k) {
                continue;
            }
            if (edges.containsKey(node)) {
              for (int[] edge : edges.get(node)) {
                 int nextCost = cost+edge[1], nextNode = edge[0];
                 if (nextCost < price[nextNode]) {
                    price[nextNode] = nextCost;
                    queue.offer(new int[] {nextCost, nextNode, stops+1});
                 }
              }
            }
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
}
