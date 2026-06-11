class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
         for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int finish = 0;
        for (int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finish++;
            for (int neighbour : adjList.get(course)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return finish == numCourses;
    }
}
