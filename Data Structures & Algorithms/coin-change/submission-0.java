class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] seen = new boolean[amount+1];
        seen[0] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int current = queue.poll();
                for (int coin : coins) {
                    int next = coin + current;
                    if (next == amount) {
                        return result;
                    }
                    if (next > amount || seen[next]) {
                        continue;
                    }
                    seen[next] = true;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
