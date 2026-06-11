class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n=points.length;
        int[] dist = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int edges = 0, node = 0, result = 0, nextNode = -1;

        while (edges < n-1) {
            visit[node] = true;
            nextNode = -1;
            for (int i=0; i<n; i++) {
                if (visit[i]) {
                    continue;
                }
                int currDist = Math.abs(points[i][0] - points[node][0]) +
                               Math.abs(points[i][1] - points[node][1]);
                dist[i] = Math.min(dist[i], currDist);
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }
            result += dist[nextNode];
            edges++;
            node = nextNode;
        }
        return result;
    }
}
