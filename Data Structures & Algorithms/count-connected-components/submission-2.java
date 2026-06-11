class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visit = new boolean[n];
         for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int result = 0;
        for (int node=0; node<n; node++) {
            if (!visit[node]) {
                dfs(adjList, node, visit);
                result++;
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> adjList, int node, boolean[] visit) {
        visit[node] = true;
        for (int nei : adjList.get(node)) {
            if (!visit[nei]) {
                dfs(adjList, nei, visit);
            }
        }
    }
}
