class KthLargest {

    PriorityQueue<Integer> heap;
    int threshold;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.threshold = k;

        for (int num : nums) {
            heap.offer(num);
            if(heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > this.threshold) {
            heap.poll();
        }
        return heap.peek();
    }
}