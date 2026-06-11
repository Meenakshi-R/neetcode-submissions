class Node {
    int left;
    int right;
    String s;

    public Node(int left, int right, String s) {
        this.left = left;
        this.right = right;
        this.s = s;
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, 0, ""));

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            int left = current.left;
            int right = current.right;
            String s = current.s;

            if (s.length() == 2*n) {
                result.add(s);
            }
            if (left < n) {
                stack.push(new Node(left+1, right, s+"("));
            }
            if (right < left) {
                stack.push(new Node(left, right+1, s+")"));
            }
        }
        return result;
    }
}
