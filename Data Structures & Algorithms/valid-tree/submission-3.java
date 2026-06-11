class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, -1});
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int node = currentNode[0];
            int parent = currentNode[1];

            visited.add(node);
            for (int nei : adjList.get(node)) {
                if (nei == parent) {
                    continue;
                }
                if (visited.contains(nei)) {
                    return false;
                }
                queue.offer(new int[]{nei, node});
            }
        }
        return visited.size() == n;
    }
}