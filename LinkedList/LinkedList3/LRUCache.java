package LinkedList.LinkedList3;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Doubly linked list node
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head; // Dummy head (least recently used side)
    private final Node tail; // Dummy tail (most recently used side)

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);          // cache: {1=1}
        lru.put(2, 2);          // cache: {1=1, 2=2}
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3);          // evicts key 2, cache: {1=1, 3=3}
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4);          // evicts key 1, cache: {3=3, 4=4}
        System.out.println(lru.get(1)); // returns -1
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }

    // LRU Cache implementation using a HashMap and a doubly
    // linked list. Get and put operations run in O(1) time.
    //
    // Approach: We maintain a doubly linked list where nodes
    // are ordered by access time. The head side stores the
    // least recently used (LRU) item and the tail side stores
    // the most recently used (MRU) item. A HashMap provides
    // O(1) lookup of nodes. On get(), we move the accessed
    // node to the tail. On put(), we add a new node to the
    // tail and evict from the head if capacity is exceeded.

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Get the value of the key if it exists, otherwise -1.
    // Time complexity: O(1)
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // Move the accessed node to the tail (MRU position)
        removeNode(node);
        addToTail(node);
        return node.value;
    }

    // Add or update a key-value pair.
    // Time complexity: O(1)
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            // Update existing node and move to tail
            node.value = value;
            removeNode(node);
            addToTail(node);
        } else {
            // Create a new node
            if (cache.size() >= capacity) {
                // Evict the LRU node (node after head)
                Node lru = head.next;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToTail(newNode);
        }
    }

    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add a node to the tail (MRU position)
    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

}
