class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        for (int[] flight : flights) {
            edges.computeIfAbsent(flight[0], x->new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, src, 0});
        prices[src] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int time = current[0], source = current[1], stops = current[2];

            if (stops > k) {
                continue;
            }
            if (edges.containsKey(source)) {
                for (int[] next : edges.get(source)) {
                    int newTime = time + next[1];
                    int target = next[0];

                    if (prices[target] > newTime) {
                        prices[target] = newTime;
                        queue.offer(new int[]{newTime, target, stops+1});
                    }
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}