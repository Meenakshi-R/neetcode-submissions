class Node {
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Node left;
    Node right;
    int capacity;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        left.next = right;
        right.prev = left;
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);
        if (cache.size() > capacity) {
            Node LRU = this.left.next;
            remove(LRU);
            cache.remove(LRU.key);
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
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
