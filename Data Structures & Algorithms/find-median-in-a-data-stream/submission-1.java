class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    boolean even = true;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        }
        else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if (even) {
            return ((small.peek() + large.peek()))/2.0;
        }
        return small.peek();
    }
}



