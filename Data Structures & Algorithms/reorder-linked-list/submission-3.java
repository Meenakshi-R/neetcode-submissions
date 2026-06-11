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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next, previous = null;
        slow.next = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        }
        ListNode first = head;
        second = previous;
        while(first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
