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
        if(node == null) {
            return node;
        }
        if(node.neighbors.size() == 0) {
            Node clone = new Node(node.val);
            return clone;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node nei : node.neighbors) {
            if(map.containsKey(nei)) {
                clone.neighbors.add(map.get(nei));
            }
            else {
                clone.neighbors.add(dfs(nei, map));
            }
        }
        return clone;
    }
}