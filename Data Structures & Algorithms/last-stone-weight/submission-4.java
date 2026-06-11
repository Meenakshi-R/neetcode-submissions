class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int stone : stones) {
            heap.offer(-stone);
        }
        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();

            if (first < second) {
                heap.offer(first-second);
            }
        }
        return heap.size() == 1 ? Math.abs(heap.poll()) : 0;
    }
}