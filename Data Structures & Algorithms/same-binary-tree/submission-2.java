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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q!=null) || (p!=null && q==null)) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode nodeP = queue1.poll();
            TreeNode nodeQ = queue2.poll();

            if (nodeP == null && nodeQ == null) {
                continue;
            }
            if (nodeP==null || nodeQ==null || nodeP.val != nodeQ.val) {
                return false;
            }
            queue1.offer(nodeP.left);
            queue1.offer(nodeP.right);
            queue2.offer(nodeQ.left);
            queue2.offer(nodeQ.right);
        }
        return true;
    }
}
