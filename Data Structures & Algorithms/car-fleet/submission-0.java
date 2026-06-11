class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        int n = position.length;

        for (int i=0; i<n; i++) {
            map.put(position[i], (double) (target-position[i])/speed[i]);
        }
        double time = 0;
        int fleets = 0;
        for(double cur : map.values()) {
            if (cur > time) {
                time = cur;
                fleets++;
            }
        }
        return fleets;
    }
}
