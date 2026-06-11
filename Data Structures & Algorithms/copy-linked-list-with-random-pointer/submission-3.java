/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;


        while (current != null) {
            Node clone = new Node(current.val);
            Node next = current.next;
            current.next = clone;
            clone.next = next;
            current = current.next.next;
        }
        current = head;
        while(current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            else {
                current.next.random = null;
            }
            current = current.next.next;
        }
        Node dummy = new Node(0);
        Node result = dummy;
        current = head;
        while (current != null) {
            Node clone = current.next;
            result.next = clone;
            current.next = clone.next;
            result = result.next;
            current = current.next;
        }
        return dummy.next;
    }
}
