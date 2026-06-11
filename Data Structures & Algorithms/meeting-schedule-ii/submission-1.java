/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0)+1);
            map.put(interval.end, map.getOrDefault(interval.end, 0)-1);
        }
        int prev = 0, result = 0;
        for (int key : map.keySet()) {
            prev+=map.get(key);
            result = Math.max(prev, result);
        }
        return result;
    }
}
