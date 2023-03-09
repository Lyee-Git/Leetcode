
/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */
// @lc code=start
import java.util.*;

class TrieMap<V> {
    private static class TrieNode<V> {
        V value = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

    private static final int R = 26;

    private TrieNode<V> root;

    private TrieNode<V> getNode(TrieNode<V> node, String word) {
        int n = word.length();
        TrieNode<V> p = node;
        for (int i = 0; i < n; i++) {
            if (p == null)
                return null;
            char c = word.charAt(i);
            int index = c - 'a';
            p = p.children[index];
        }
        return p;
    }

    public V get(String word) {
        TrieNode<V> node = getNode(root, word);
        if (node == null)
            return null;
        else
            return node.value;
    }

    public void remove(String word) {
        if (get(word) == null)
            return;
        root = remove(root, word, 0);
    }

    // delete word[i...] from Trie Tree with root node, return root
    private TrieNode<V> remove(TrieNode<V> node, String word, int i) {
        // Pre-Order position: Handle base cases
        if (node == null)
            return null;
        if (i == word.length()) {
            node.value = null;
        } else {
            char c = word.charAt(i);
            int index = c - 'a';
            node.children[index] = remove(node.children[index], word, i + 1);
        }
        // Post-order position: remove nodes on path to deleted node that has empty val
        // and empty children
        if (node.value != null)
            return node;
        for (int k = 0; k < R; k++) {
            if (node.children[k] != null)
                return node;
        }
        return null;
    }

    public void insert(String word, V v) {
        if (root == null) {
            root = new TrieNode<V>();
        }
        TrieNode<V> p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c -= 'a';
            if (p.children[c] == null) {
                p.children[c] = new TrieNode<V>();
            }
            p = p.children[c];
        }
        p.value = v;
    }

    public List<String> getWithPrefix(String prefix) {
        TrieNode<V> node = root;
        List<String> res = new ArrayList<>();
        TrieNode<V> pre = getNode(node, prefix);
        if (pre == null)
            return res;
        else {
            StringBuilder sb = new StringBuilder(prefix);
            traverse(sb, pre, res);
        }
        return res;
    }

    private void traverse(StringBuilder sb, TrieNode<V> node, List<String> res) {
        TrieNode<V> p = node;
        if (p == null)
            return;
        if (p.value != null) {
            res.add(sb.toString());
        }
        for (int i = 0; i < R; i++) {
            char c = (char) (i + 'a');
            sb.append(c);
            traverse(sb, p.children[i], res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class MapSum {
    TrieMap<Integer> trieMap;

    public MapSum() {
        this.trieMap = new TrieMap<>();
    }

    public void insert(String key, int val) {
        trieMap.insert(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        List<String> hasPrefix = trieMap.getWithPrefix(prefix);
        for (String s : hasPrefix) {
            sum += trieMap.get(s);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end
