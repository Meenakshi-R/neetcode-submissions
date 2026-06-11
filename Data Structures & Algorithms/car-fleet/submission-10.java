class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] fleets = new double[n][2];

        for (int i=0; i<position.length; i++) {
            fleets[i][0] = position[i];
            fleets[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(fleets, (a,b) -> Double.compare(b[0], a[0]));
        int result = 0;
        double time = 0;

        for (int i=0; i<fleets.length; i++) {
            if (time < fleets[i][1]) {
                time = fleets[i][1];
                result++;
            }
        }
        return result;
    }
}
