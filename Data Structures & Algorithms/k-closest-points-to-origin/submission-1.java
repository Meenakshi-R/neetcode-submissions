class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int x1 = 0, y1 = 0;

        for (int[] point : points) {
            int x2 = point[0], y2 = point[1];

            int distance = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
            queue.offer(new int[]{distance, point[0], point[1]});
        }
        int[][] result = new int[k][2];
        for (int i=0; i<k; i++) {
            int[] current = queue.poll();
            result[i][0] = current[1];
            result[i][1] = current[2];
        }
        return result;
    }
}