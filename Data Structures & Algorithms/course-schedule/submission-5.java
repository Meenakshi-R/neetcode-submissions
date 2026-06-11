class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adjList.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
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
