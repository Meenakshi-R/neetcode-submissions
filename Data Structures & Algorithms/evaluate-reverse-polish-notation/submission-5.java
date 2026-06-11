class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int first = stack.pop();
                int second = stack.pop();
                switch(token) {
                    case "+": stack.push(first + second);
                               break;
                    case "-": stack.push(second - first);
                               break;  
                    case "*": stack.push(first * second);
                               break;
                    case "/": stack.push(second/first);
                               break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
