class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dest = ticket.get(1);
            adjList.computeIfAbsent(src, x-> new PriorityQueue<>()).add(dest);
        }
        List<String> itenary = new ArrayList<>();
        dfs("JFK", adjList, itenary);
        return itenary;
    }

    private void dfs(String node, Map<String, PriorityQueue<String>> adjList, List<String> itenary) {
        PriorityQueue<String> neighbors = adjList.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll(), adjList, itenary);
        }
        itenary.addFirst(node);
    }
}