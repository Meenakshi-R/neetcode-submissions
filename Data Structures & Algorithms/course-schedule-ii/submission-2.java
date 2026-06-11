class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adjList.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int finish = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[numCourses-finish-1] = course;
            finish++;

            for (int nei : adjList.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        return finish == numCourses ? result : new int[0];
    }
}