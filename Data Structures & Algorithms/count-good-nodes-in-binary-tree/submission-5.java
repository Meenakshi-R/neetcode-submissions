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
        int goodNodes = 0;
        if (root == null) {
            return goodNodes;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode node = current.getKey();
            int max = current.getValue();

            if (node.val >= max) {
                goodNodes++;
            }
            if (node.left != null) {
                queue.offer(new Pair(node.left, Math.max(max, node.val)));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, Math.max(max, node.val)));
            }
        }
        return goodNodes;
    }
}
