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
    int maxsum = 0;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxsum = root.val;
        dfs(root);
        return maxsum;
    }

    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        maxsum = Math.max(maxsum, root.val+leftMax+rightMax);
        return root.val+Math.max(leftMax, rightMax);
    }
}
