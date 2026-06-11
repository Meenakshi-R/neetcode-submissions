class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> fleetMap = new TreeMap<>(Collections.reverseOrder());
        for (int i=0; i<position.length; i++) {
            fleetMap.put(position[i], (double)(target-position[i])/speed[i]);
        } 
        double time = 0;
        int fleets = 0;
        for (double current : fleetMap.values()) {
            if (current > time) {
                time = current;
                fleets++;
            }
        }
        return fleets;
    }
}