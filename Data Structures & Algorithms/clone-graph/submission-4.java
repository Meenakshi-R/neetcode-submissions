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
            Node clone = new Node(node.val);
            return clone;
        }
        Map<Node, Node> clonedMap = new HashMap<>();
        return dfs(node, clonedMap);
    }

    private Node dfs(Node node, Map<Node, Node> clonedMap) {
        Node clone = new Node(node.val);
        clonedMap.put(node, clone);

        for (Node nei : node.neighbors) {
            if (clonedMap.containsKey(nei)) {
                clone.neighbors.add(clonedMap.get(nei));
            }
            else {
                clone.neighbors.add(dfs(nei, clonedMap));
            }
        }
        return clone;
    }
}