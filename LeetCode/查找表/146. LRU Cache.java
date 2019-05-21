import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        Node pre;
        Node next;
        int key;
        int value;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        cur.next.pre = cur.pre;
        cur.pre.next = cur.next;
        moveToTail(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if (get(key) == - 1) {
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);
            if (map.size() > capacity) {
                deleteFirstNode();
            }
            return;
        }
        Node cur = map.get(key);
        cur.value = value;
    }

    private void deleteFirstNode() {
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.pre = head;
    }

    private void moveToTail(Node node) {
        if (node == null) {
            return;
        }
        node.next = tail;
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */