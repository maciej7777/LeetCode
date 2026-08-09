package solutions.p0146;

import java.util.HashMap;

public class LRUCache {

    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMap<Integer, Node> cache;
    private final Node head = new Node(-1, -1);
    private final Node tail = new Node(-1, -1);
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity + 4, 1.0f);
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) return -1;

        removeNodeFromList(node);
        insertHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);

            insertHead(node);

            if (cache.size() > capacity) {
                Node removedNode = dropTail();
                cache.remove(removedNode.key);
            }
        } else {
            removeNodeFromList(node);

            node.value = value;

            insertHead(node);
        }
    }

    private void removeNodeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private Node dropTail() {
        Node last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        return last;
    }
}
