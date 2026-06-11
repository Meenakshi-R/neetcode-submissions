class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adjList.computeIfAbsent(pre[1], x->new ArrayList<>()).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int finish = 0;
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finish++;
            if (adjList.containsKey(course)) {
                for (int nei : adjList.get(course)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                       queue.offer(nei);
                    }
                }
            }
        }
        return finish == numCourses;
    }
}
