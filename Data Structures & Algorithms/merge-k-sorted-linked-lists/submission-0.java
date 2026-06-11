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
        if (lists == null || lists.length == 0) {
              return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for (ListNode list : lists) {
                queue.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            node = node.next;
            if (node != null) {
                queue.offer(node);
            }
        }
        return dummy.next;
    }
}
