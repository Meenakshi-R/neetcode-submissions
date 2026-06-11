class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[len-k+1];
        int index = 0;

        for (int i=0; i<len; i++) {
            if (!queue.isEmpty() && queue.peek() == i-k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()]<nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k-1) {
                result[index++] = nums[queue.peek()];
            }
        }
        return result;
    }
}