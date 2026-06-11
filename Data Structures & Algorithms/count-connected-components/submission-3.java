class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int components = 0;

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                bfs(queue, i, adjList, visited);
                components++;
            }
        }
        return components;
    }

    private void bfs(Queue<Integer> queue, int node, List<List<Integer>> adjList, boolean[] visited) {
        while(!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            for(int nei : adjList.get(current)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                }
            }
        }
    }
}