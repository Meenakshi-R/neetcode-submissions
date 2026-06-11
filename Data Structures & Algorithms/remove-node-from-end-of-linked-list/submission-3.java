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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy, current = head;

        while (n > 0) {
            current = current.next;
            n--;
        }
        while (current != null) {
            temp = temp.next;
            current = current.next;
        }
        temp.next = temp.next.next;

        return dummy.next;
    }
}
