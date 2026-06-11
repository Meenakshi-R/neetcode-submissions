class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1]-b[1]);
        int prevEnd = intervals[0][1], result = 0;

        for (int i=1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start < prevEnd) {
                result++;
            }
            else {
                prevEnd = end;
            }
        }
        return result;
    }
}
