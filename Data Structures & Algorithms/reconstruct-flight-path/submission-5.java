class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();

        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), x->new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs(targets, "JFK", result);
        Collections.reverse(result);
        
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> targets, String source, List<String> result) {
        while (targets.containsKey(source) && !targets.get(source).isEmpty()) {
            dfs(targets, targets.get(source).poll(), result);
        }
        result.add(source);
    }
}