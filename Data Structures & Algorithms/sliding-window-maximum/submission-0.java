class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
             return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int ri = 0;

        for (int i=0; i<nums.length; i++) {
             if (!queue.isEmpty() && queue.peek() == i-k) {
                   queue.poll();
             }
             while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                  queue.pollLast(); 
             }
             queue.offer(i);
             if (i >= k-1) {
                result[ri++] = nums[queue.peek()]; 
             }
        }
        return result;
    }
}
