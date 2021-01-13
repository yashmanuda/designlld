package cache.evictionpolicy;

import cache.dll.DoublyLinkedList;
import cache.dll.Node;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private DoublyLinkedList<K> dll;
    private Map<K, Node<K>> keyToNodeMap;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList<>();
        this.keyToNodeMap = new ConcurrentHashMap<>();
    }

    @Override
    public void mark(K key) {
        if (keyToNodeMap.containsKey(key)) {
            Node<K> currentNode = keyToNodeMap.get(key);
            dll.removeNode(currentNode);
            dll.addAtLast(currentNode);
        } else {
            Node<K> toAdd = new Node<>(key);
            keyToNodeMap.put(key, toAdd);
            dll.addAtLast(toAdd);
        }
    }

    @Override
    public K evict() {
        Node<K> removed = dll.removeFromHead();
        keyToNodeMap.remove(removed.getKey());
        return removed.getKey();
    }
}
