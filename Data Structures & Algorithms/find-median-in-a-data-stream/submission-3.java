class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean isEven = true;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (isEven) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        isEven = !isEven;
    }
    
    public double findMedian() {
        if (isEven) {
            return (double) (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return minHeap.peek();
    }
}
