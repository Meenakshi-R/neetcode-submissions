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
        if (head == null) {
            return head;
        }
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            Node next = temp.next;
            temp.next = copyNode;
            copyNode.next = next;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                  temp.next.random = temp.random.next;
            }
            else {
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        Node dummy = new Node(0);
        Node result = dummy;
        temp = head;

        while (temp != null) {
            Node copyNode = temp.next;
            result.next = copyNode;
            result = result.next;

            temp.next = copyNode.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
