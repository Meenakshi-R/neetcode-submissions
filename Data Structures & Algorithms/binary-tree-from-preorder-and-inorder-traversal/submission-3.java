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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(0, preorder.length-1, preorder, 0, inorder.length-1, inorder, inMap);
    }

    private TreeNode build(int prestart, int preend, int[] preorder, int instart, int inend, int[] inorder, 
                                          Map<Integer, Integer> inMap) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot = inMap.get(root.val);
        int numsOnLeft = inRoot - instart;

        root.left = build(prestart+1, prestart+numsOnLeft, preorder, instart, inRoot-1, inorder, inMap);
        root.right = build(prestart+numsOnLeft+1, preend, preorder, inRoot+1, inend, inorder, inMap);

        return root;
    }
}
