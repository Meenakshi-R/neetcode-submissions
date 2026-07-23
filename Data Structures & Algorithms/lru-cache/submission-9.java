class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    Node left;
    Node right;
    int capacity;
    Map<Integer, Node> cacheMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            remove(cacheMap.get(key));
        }
        Node node = new Node(key, value);
        insert(node);
        cacheMap.put(key, node);
        if(cacheMap.size() > this.capacity) {
            Node LRU = this.left.next;
            remove(LRU);
            cacheMap.remove(LRU.key);
        }
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
}
