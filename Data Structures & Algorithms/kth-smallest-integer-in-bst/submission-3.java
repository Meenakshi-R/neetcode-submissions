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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            while (curr.left != null) {
                curr = curr.left;
                stack.push(curr);
            }
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return -1;
    }
}
