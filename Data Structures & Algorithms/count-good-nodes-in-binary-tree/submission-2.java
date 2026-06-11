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
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        int goodNodes = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int maxValue = current.getValue();

            if (node.val >= maxValue) {
                goodNodes++;
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, Math.max(maxValue, node.val)));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, Math.max(maxValue, node.val)));
            }
        }
        return goodNodes;
    }
}
