class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int stone : stones) {
             queue.offer(-stone);
        }
        while (!queue.isEmpty() && queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();

            if (second > first) {
                queue.offer(first-second);
            }
        }
        queue.offer(0);
        return Math.abs(queue.peek());
    }
}
