class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adjList.computeIfAbsent(pre[0], x->new ArrayList<>()).add(pre[1]);
            indegree[pre[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int finish = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[numCourses-finish-1] = course;
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
        return finish==numCourses ? result : new int[0];
    }
}
