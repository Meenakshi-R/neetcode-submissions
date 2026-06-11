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
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = depth(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = depth(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight-rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
             return true;
        }
        return depth(root) != -1;
    }
}
