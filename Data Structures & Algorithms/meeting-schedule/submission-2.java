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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        Collections.sort(intervals, Comparator.comparingInt(i -> i.end));
        
        for (int i=1; i<intervals.size(); i++) {
            Interval prevInterval = intervals.get(i-1);
            Interval interval = intervals.get(i);
            
            if (interval.start < prevInterval.end) {
                return false;
            }
        }
        return true;
    }
}
