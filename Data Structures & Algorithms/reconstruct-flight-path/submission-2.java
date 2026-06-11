class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> route = new ArrayList<>();
        if (tickets == null || tickets.isEmpty()) {
            return route;
        }
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            targets.computeIfAbsent(src, k -> new PriorityQueue()).add(dst);
        }
        dfs(targets, route, "JFK");

        return route;
    }

    private void dfs(Map<String, PriorityQueue<String>> targets, List<String> route, String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            dfs(targets, route, targets.get(airport).poll());
        }
        route.add(0, airport);
    }
}
