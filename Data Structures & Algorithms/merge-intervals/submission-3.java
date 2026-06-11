class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            int lastEnd = result.get(result.size()-1)[1];

            if (start <= lastEnd) {
                result.get(result.size()-1)[1] = Math.max(lastEnd, end);
            }
            else {
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
