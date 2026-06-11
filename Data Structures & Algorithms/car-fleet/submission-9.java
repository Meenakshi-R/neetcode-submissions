class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> fleets = new TreeMap<>(Collections.reverseOrder());

        for (int i=0; i<position.length; i++) {
            fleets.put(position[i], (double) (target-position[i])/speed[i]);
        }
        int result = 0;
        double time = 0;

        for (double fleetsValue : fleets.values()) {
            if (time < fleetsValue) {
                time = fleetsValue;
                result++;
            }
        }
        return result;
    }
}
