package StackQueue.StackQueue2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    // LFU Cache implementation. Evicts the least frequently
    // used item when capacity is exceeded. If there is a tie,
    // the least recently used item among them is evicted.
    // Time complexity: O(1) for both get and put.

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToVal;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>>
            freqToKeys;

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);          // cache: {1=1, freq=1}
        lfu.put(2, 2);          // cache: {1=1, 2=2, freq=1}
        System.out.println(lfu.get(1)); // 1, freq of 1 -> 2
        lfu.put(3, 3);          // evicts key 2 (freq=1, LRU)
        System.out.println(lfu.get(2)); // -1
        System.out.println(lfu.get(3)); // 3, freq of 3 -> 2
        lfu.put(4, 4);          // evicts key 1 (freq=2 vs 1)
        System.out.println(lfu.get(1)); // -1
        System.out.println(lfu.get(3)); // 3, freq of 3 -> 3
        System.out.println(lfu.get(4)); // 4, freq of 4 -> 2
    }

    // Approach: We maintain three maps:
    // 1. keyToVal: stores key -> value mapping
    // 2. keyToFreq: stores key -> frequency mapping
    // 3. freqToKeys: stores frequency -> set of keys with
    //    that frequency (LinkedHashSet maintains insertion
    //    order for LRU behavior within same frequency)
    // minFreq keeps track of the current minimum frequency
    // for efficient eviction.

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    // Get the value of the key if it exists, otherwise -1.
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        // Increase frequency of the key
        increaseFreq(key);
        return keyToVal.get(key);
    }

    // Add or update a key-value pair.
    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        // Evict if at capacity
        if (keyToVal.size() >= capacity) {
            evict();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1,
                k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void increaseFreq(int key) {
        int oldFreq = keyToFreq.get(key);
        int newFreq = oldFreq + 1;

        keyToFreq.put(key, newFreq);

        // Remove from old frequency set
        freqToKeys.get(oldFreq).remove(key);
        if (freqToKeys.get(oldFreq).isEmpty()) {
            freqToKeys.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq = newFreq;
            }
        }

        // Add to new frequency set
        freqToKeys.computeIfAbsent(newFreq,
                k -> new LinkedHashSet<>()).add(key);
    }

    private void evict() {
        // Get the LRU key among the minimum frequency keys
        LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
        int keyToEvict = keys.iterator().next();
        keys.remove(keyToEvict);
        if (keys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }

        keyToVal.remove(keyToEvict);
        keyToFreq.remove(keyToEvict);
    }

}
