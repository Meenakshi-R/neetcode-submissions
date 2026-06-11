class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n-k+1];
        int index = 0;

        for (int i=0; i<n; i++) {
            while (!deque.isEmpty() && deque.peek() <= i-k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i>=k-1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }
}
