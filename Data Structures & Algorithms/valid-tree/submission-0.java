class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return true;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, visited, adjList)) {
            return false;
        }
        return visited.size()==n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> adjList) {
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        for (int nei : adjList.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (!dfs(nei, node, visited, adjList)) {
                return false;
            }
        }
        return true;
    }
}