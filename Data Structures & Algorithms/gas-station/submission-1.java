class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0) {
            return 0;
        }
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int tank = 0, result = 0;
        for (int i=0; i<gas.length; i++) {
            tank += (gas[i] - cost[i]);
            if (tank < 0) {
                tank = 0;
                result = i+1;
            }
        }
        return result;
    }
}
