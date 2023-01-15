
/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */
import java.util.*;

// @lc code=start
class LFUCache {
    class Node {
        int key, val, freq;
        Node prev, next;

        Node() {
            this(-1, -1, 0);
        }

        Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node();
            tail = new Node();
            size = 0;
            head.next = head.prev = tail;
            tail.next = tail.prev = head;
        }

        public int getSize() {
            return size;
        }

        void addLast(Node node) { // 最近插入的元素放在尾部
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node getFirst() {
            return head.next;
        }

        Node getLast() {
            return tail.prev;
        }
    }

    int minFreq;
    int capacity;
    Map<Integer, Node> keyToNode;
    Map<Integer, DoubleList> freqToNodes;

    public LFUCache(int capacity) {
        freqToNodes = new HashMap<>();
        keyToNode = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }

    private void increaseFreq(int key) {
        if (!keyToNode.containsKey(key))
            return;
        Node node = keyToNode.get(key);
        int freq = node.freq;
        node.freq++;
        freqToNodes.get(freq).remove(node);
        // 检查原freq是否已经没有对应的节点
        if (freqToNodes.get(freq).getSize() == 0) {
            freqToNodes.remove(freq);
            if (freq == minFreq)
                minFreq++;
        }
        freqToNodes.putIfAbsent(freq + 1, new DoubleList());
        DoubleList newList = freqToNodes.get(freq + 1);
        newList.addLast(node);
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key) || capacity == 0)
            return -1;
        Node node = keyToNode.get(key);
        increaseFreq(key);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.val = value;
            increaseFreq(key);
        } else {
            if (capacity <= keyToNode.size()) {
                Node node = freqToNodes.get(minFreq).getFirst();
                keyToNode.remove(node.key);
                freqToNodes.get(minFreq).remove(node);
                if (freqToNodes.get(minFreq).getSize() == 0)
                    freqToNodes.remove(minFreq);
            }
            Node node = new Node(key, value, 1);
            keyToNode.put(key, node);
            freqToNodes.putIfAbsent(1, new DoubleList());
            freqToNodes.get(1).addLast(node);
            minFreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
