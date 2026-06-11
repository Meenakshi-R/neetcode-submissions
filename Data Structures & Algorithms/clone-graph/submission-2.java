/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }
        Map<Node, Node> cloneMap = new HashMap<>();
        return dfs(node, cloneMap);
    }

    private Node dfs(Node node, Map<Node, Node> cloneMap) {
        Node clone = new Node(node.val);
        cloneMap.put(node, clone);

        for (Node nei : node.neighbors) {
            if (cloneMap.containsKey(nei)) {
                clone.neighbors.add(cloneMap.get(nei));
            }
            else {
                clone.neighbors.add(dfs(nei, cloneMap));
            }
        }
        return clone;
    }
}