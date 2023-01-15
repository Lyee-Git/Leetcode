/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */
import java.util.*;
// @lc code=start
class LRUCache {
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    class DoubleList {
        private Node head, tail;
        private int size;
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node getFirst() {
            if (head.next == tail)
                return null;
            Node first = head.next;
            return first;
        }
        public int getSize() { return size; }
    }

    private HashMap<Integer, Node> map;
    private DoubleList dList;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        dList = new DoubleList();
        this.capacity = capacity;
    }
    
    private void removeKey(int key) {
        if (!map.containsKey(key))
            return;
        Node node = map.get(key);
        map.remove(key); // Wrong version: map.put(key,null)!!
        dList.remove(node);
    }

    private void removeLestRecently() {
        if (dList.getSize() == 0)
            return;
        Node node = dList.getFirst();
        int keyLRU = node.key;
        removeKey(keyLRU);
    }

    private void markasRecently(int key) {
        if (!map.containsKey(key))
            return;
        Node node = map.get(key);
        dList.remove(node);
        dList.addLast(node);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        dList.addLast(node);
        map.put(key, node);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            markasRecently(key);
            return map.get(key).val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeKey(key);
            addRecently(key, value);
        }
        else {
            if (dList.getSize() < this.capacity) {
                addRecently(key, value);
            }
            else {
                removeLestRecently();
                addRecently(key, value);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

