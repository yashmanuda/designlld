package cache.dll;

public class DoublyLinkedList<K> {
    private Node<K> head;
    private Node<K> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        size = 0;
    }

    synchronized public void removeNode(Node<K> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    synchronized public void addAtLast(Node<K> node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    synchronized public Node<K> removeFromHead() {
        Node<K> removed = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        removed.next = null;
        removed.prev = null;
        size--;
        return removed;

    }
}
