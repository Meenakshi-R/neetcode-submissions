class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int prevEnd = intervals[0][1];
        int overlap = 0;

        for (int i=1; i<intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0], end = interval[1];
            if (start < prevEnd) {
                overlap++;
            }
            else {
                prevEnd = end;
            }
        }
        return overlap;
    }
}
