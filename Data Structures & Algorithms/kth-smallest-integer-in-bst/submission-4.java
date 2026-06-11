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
        TreeNode temp = root;

        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        while (k-- > 0) {
            TreeNode node = stack.pop();

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
