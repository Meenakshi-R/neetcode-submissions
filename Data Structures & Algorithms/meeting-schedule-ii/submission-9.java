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
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!queue.isEmpty() && queue.peek() <= interval.start) {
                queue.poll();
            }
            queue.offer(interval.end);
        }
        return queue.size();
    }
}