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
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(i -> i.val));
        for (ListNode list : lists) {
            queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}
