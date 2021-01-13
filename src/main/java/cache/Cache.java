package cache;

import cache.evictionpolicy.EvictionPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache<K, V> {
    private final Map<K, V> keyValueMap;
    private final EvictionPolicy<K> evictionPolicy;
    private final int MAX_SIZE;

    public Cache(EvictionPolicy<K> evictionPolicy, int MAX_SIZE) {
        this.keyValueMap = new ConcurrentHashMap<>();
        this.evictionPolicy = evictionPolicy;
        this.MAX_SIZE = MAX_SIZE;
    }


    /**
     * @param key   key of the cached object
     * @param value value to be cached
     */
    public void put(K key, V value) {
        int currentSize = keyValueMap.size();
        if (keyValueMap.containsKey(key)) {
            evictionPolicy.mark(key);
            keyValueMap.put(key, value);
        } else {
            if (currentSize >= MAX_SIZE) {
                K evictedKey = evictionPolicy.evict();
                keyValueMap.remove(evictedKey);
            }
            keyValueMap.put(key, value);
            evictionPolicy.mark(key);
        }
    }

    /**
     * @param key key for which value is to be retrieved
     * @return value corresponding to the key, null if no value is present for the key
     */
    public V get(K key) {
        evictionPolicy.mark(key);
        return keyValueMap.getOrDefault(key, null);
    }
}
