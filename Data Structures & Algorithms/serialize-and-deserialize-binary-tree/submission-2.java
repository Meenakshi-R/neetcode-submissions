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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "N,";
        }
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.append("N,");
            }
            else {
                result.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if (nodes[0].equals("N")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!nodes[index].equals("N")) {
               node.left = new TreeNode(Integer.parseInt(nodes[index]));
               queue.offer(node.left);
            }
            index++;
            if (!nodes[index].equals("N")) {
               node.right = new TreeNode(Integer.parseInt(nodes[index]));
               queue.offer(node.right);
            }
            index++;
        }
        return root;   
    }
}
