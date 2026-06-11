class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];

            if(newInterval == null || end < newInterval[0]) {
                result.add(interval);
            }
            else if (newInterval[1] < start) {
                result.add(newInterval);
                result.add(interval);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }
        if (newInterval != null) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }
}
