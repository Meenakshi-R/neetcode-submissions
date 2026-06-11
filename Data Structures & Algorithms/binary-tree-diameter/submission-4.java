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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {  
        maxHeight(root);
        return max;
    }

    private int maxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxHeight(node.left);
        int right = maxHeight(node.right);
        max = Math.max(left+right, max);
        return 1+Math.max(left, right);
    }
}
