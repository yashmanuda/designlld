package cache.dll;

import lombok.Getter;

@Getter
public class Node<T> {
    T key;
    Node<T> next;
    Node<T> prev;

    public Node(T key) {
        this.key = key;
        this.next = null;
        this.prev = null;
    }

    Node() {
        next = null;
        prev = null;
        key = null;
    }
}