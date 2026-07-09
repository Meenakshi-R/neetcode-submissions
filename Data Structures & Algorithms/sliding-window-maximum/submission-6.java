class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int index=0;

        for (int i=0; i<n; i++) {
            while (!deque.isEmpty() && deque.peek() <= i-k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k-1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
