class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> edges = new HashMap<>();

        for (List<String> ticket : tickets) {
            edges.computeIfAbsent(ticket.get(0), x->new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs(edges, result, "JFK");

        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> edges, List<String> result, String source) {
        while (edges.containsKey(source) && !edges.get(source).isEmpty()) {
            dfs(edges, result, edges.get(source).poll());
        }
        result.add(0, source);
    }
}
