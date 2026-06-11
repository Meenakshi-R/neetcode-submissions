class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return new int[0][];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a->a[0]));

        for (int[] point : points) {
            int distance = (point[0] * point[0]) + (point[1]*point[1]);
            queue.offer(new int[]{distance, point[0], point[1]});
        }
        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            int[] element = queue.poll();
            result[i] = new int[]{element[1], element[2]};
        }
        return result;
    }
}
