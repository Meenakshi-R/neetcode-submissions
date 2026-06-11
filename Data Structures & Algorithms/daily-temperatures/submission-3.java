class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] result = new int[length];

        for (int i=length-1; i>=0; i--) {
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
