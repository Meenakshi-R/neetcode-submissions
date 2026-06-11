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
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
    }

    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, 
                            Map<Integer, Integer> inMap) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int rootIndex = inMap.get(root.val);
        int numsOnLeft = rootIndex - instart;

        root.left = build(preorder, prestart+1, prestart+numsOnLeft, inorder, instart, rootIndex-1, inMap);
        root.right = build(preorder, prestart+numsOnLeft+1, preend, inorder, rootIndex+1, inend, inMap);

        return root;
    }
}
