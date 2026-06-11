class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
           return 0;
        
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int left = stack.pop();
                int right = stack.pop();

                switch (token) {
                   case "+":
                     stack.push(left + right);
                     break;
                   case "-":
                     stack.push(right - left);
                     break;
                   case "*":
                     stack.push(left * right);
                     break;
                   case "/":
                     stack.push(right / left);
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
