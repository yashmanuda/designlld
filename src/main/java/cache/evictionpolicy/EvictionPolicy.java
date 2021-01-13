package cache.evictionpolicy;

public interface EvictionPolicy<K> {
    void mark(K key);

    K evict();
}
