
class Main {
    class Trie {
        public static final int R = 26;

        private class TrieNode {
            Integer val;
            TrieNode[] children = new TrieNode[R];
        }

        private TrieNode root;

        public Trie() {
            this.root = null;
        }

        TrieNode getNode(TrieNode node, String key) {
            TrieNode p = node;
            int n = key.length();
            for (int i = 0; i < n; i++) {
                if (p == null)
                    return null;
                char c = key.charAt(i);
                p = p.children[c - 'a'];
            }
            return p;
        }

        /** Inserts a word into the trie. */
        public void insert(String word, int val) {
            if (root == null) {
                root = new TrieNode();
            }
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.val = val;
        }

        int res = 0;

        public int hasPrefixSum(String prefix) {
            TrieNode p = root;
            res = 0;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (p == null || p.children[index] == null) {
                    return res;
                }
                p = p.children[index];
            }
            traverse(p);
            return res;
        }

        private void traverse(TrieNode node) {
            if (node != null && node.val != null) {
                res += node.val;
            }
            for (int i = 0; i < R; i++) {
                if (node.children[i] != null) {
                    traverse(node.children[i]);
                }
            }
        }
    }

    Trie trie = new Trie();

    /** Initialize your data structure here. */
    public static void main(String[] args) {
        Main main = new Main();
        main.insert("apple", 3);
        main.sum("ap");
        main.insert("app", 2);
        main.sum("ap");
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.hasPrefixSum(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
