class Node {
    Node head;
    int value;
    int min;
    Node next;

    public Node(int value, int min, Node next) {
        this.value = value;
        this.min = min;
        this.next = next;
    }
}

class MinStack {

    Node head = null;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        }
        else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.min;
    }
}
