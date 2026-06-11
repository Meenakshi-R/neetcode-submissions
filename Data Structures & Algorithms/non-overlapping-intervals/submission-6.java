class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1], b[1]));
        int lastEnd = intervals[0][1];
        int overlap = 0;

        for (int i=1; i<intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (start < lastEnd) {
                overlap++;
            }
            else {
                lastEnd = end;
            }
        }
        return overlap;
    }
}