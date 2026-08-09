package solutions.p0146;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private static class LRUHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int capacity;

        public LRUHashMap(int capacity) {
            super(capacity + 1, 1.0f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    private final LRUHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LRUHashMap<>(capacity);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
