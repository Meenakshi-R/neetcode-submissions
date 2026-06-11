class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adjList.computeIfAbsent(pre[1], x->new ArrayList<>()).add(pre[0]);
        }
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);

            if (adjList.containsKey(course)) {
                for (int nei : adjList.get(course)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        queue.offer(nei);
                    }
                }
            }
        }
        if (result.size() != numCourses) {
            return new int[0];
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
