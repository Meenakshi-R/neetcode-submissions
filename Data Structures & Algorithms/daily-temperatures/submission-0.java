class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i>=0; i--) {
             while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                 stack.pop();
             }
             if (!stack.isEmpty()) {
                result[i] = stack.peek()-i;
             }
             stack.push(i);
        }
        return result;
    }
}
