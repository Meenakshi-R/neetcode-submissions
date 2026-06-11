/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, int[]> map = new HashMap<>();
        map.put(null, new int[]{0, 0});
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            }
            else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            }
            else {
                node = stack.pop();
                int[] left = map.get(node.left);
                int[] right = map.get(node.right);
                int leftHeight = left[0];
                int leftDiameter = left[1];
                int rightHeight = right[0];
                int rightDiameter = right[1];

                int height = 1+ Math.max(leftHeight, rightHeight);
                int diameter = Math.max(leftHeight+rightHeight, Math.max(leftDiameter, rightDiameter));
                map.put(node, new int[]{height, diameter});
            }
        }
        return map.get(root)[1];
    }
}
