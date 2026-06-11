/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));

        for(ListNode list : lists) {
            queue.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            temp.next = curr;
            temp = temp.next;
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }
        return dummy.next;
    }
}
