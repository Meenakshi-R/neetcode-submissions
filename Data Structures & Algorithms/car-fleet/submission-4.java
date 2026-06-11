class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> fleets = new TreeMap<>(Collections.reverseOrder());

        for (int i=0; i<position.length; i++) {
            fleets.put(position[i], (double)(target-position[i])/speed[i]);
        }
        double time = 0;
        int result = 0;

        for (double currentTime : fleets.values()) {
            if (currentTime > time) {
                time = currentTime;
                result++;
            }
        }
        return result;
    }
}