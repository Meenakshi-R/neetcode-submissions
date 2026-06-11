class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int finish = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            finish++;

            for (int nei : adjList.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        return finish == numCourses;
    }
}
