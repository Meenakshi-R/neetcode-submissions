class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            return new int[0];
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[1]]++;
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] output = new int[numCourses];
        int finish = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            output[numCourses-finish-1] = course;
            finish++;
            for (int nei : adjList.get(course)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        if (finish != numCourses) {
            return new int[0];
        }
        return output;
    }
}
