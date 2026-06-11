class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();

        for(List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), x->new PriorityQueue<>()).offer(ticket.get(1));
        }
        List<String> itenary = new ArrayList<>();
        dfs(targets, itenary, "JFK");

        return itenary;
    }

    private void dfs(Map<String, PriorityQueue<String>> targets, List<String> itenary, String source) {
        while (targets.containsKey(source) && !targets.get(source).isEmpty()) {
            dfs(targets, itenary, targets.get(source).poll());
        }
        itenary.add(0, source);
    }
}