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
        if(root == null) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (k-- > 0) {
            TreeNode node = stack.pop();
            if (k == 0) {
                return node.val;
            }
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
