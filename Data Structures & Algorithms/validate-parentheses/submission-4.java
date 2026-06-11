class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < s.length()) {
            char token = s.charAt(index);
            if (token == '(') {
                stack.push(')');
            }
            else if (token == '[') {
                stack.push(']');
            }
            else if (token == '{') {
                stack.push('}');
            }
            else {
                if (stack.isEmpty() || stack.pop() != token) {
                    return false;
                }
            }
            index++;
        }
        return stack.isEmpty();
    }
}
