/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    private static class TrieNode {
        Object value = null;
        TrieNode[] children = new TrieNode[R];
    }

    private static final int R = 26;

    private TrieNode root;

    private TrieNode getNode(TrieNode node, String key) {
        TrieNode p = node;
        int n = key.length();
        for (int i = 0; i < n; i++) {
            if (p == null)
                return null;
            char c = key.charAt(i);
            c -= 'a';
            p = p.children[c];
        }
        return p;
    }

    public Trie() {
        this.root = null;
    }

    public void insert(String word) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c -= 'a';
            if (p.children[c] == null) {
                p.children[c] = new TrieNode();
            }
            p = p.children[c];
        }
        p.value = new Object();
    }

    public boolean search(String word) {
        TrieNode res = getNode(root, word);
        return res != null && res.value != null;
    }

    public boolean startsWith(String prefix) {
        return getNode(root, prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end
