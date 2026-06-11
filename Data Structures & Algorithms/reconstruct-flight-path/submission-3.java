class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();

        if(tickets == null || tickets.isEmpty()) {
            return result;
        }
        Map<String, PriorityQueue<String>> targets = new HashMap<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);

            targets.computeIfAbsent(src, k->new PriorityQueue<>()).add(dest);
        }
        dfs(targets, result, "JFK");
        return result; 
    }

    private void dfs(Map<String, PriorityQueue<String>> targets, List<String> result, String src) {
        while (targets.containsKey(src) && !targets.get(src).isEmpty()) {
            dfs(targets, result, targets.get(src).poll());
        }
        result.add(0, src);
    }
}
