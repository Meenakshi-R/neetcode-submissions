class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean even = true;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return (double) (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return minHeap.peek();
    }
}