class MinStack {

    private class Node {
         int value;
         int min;
         Node next;

         public Node(int val, int min, Node next) {
            this.value = val;
            this.min = min;
            this.next = next;
         }
    }
    private Node head;

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
