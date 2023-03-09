/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class TrieSet {
    private static class TrieNode {
        Object value = null;
        TrieNode[] children = new TrieNode[R];
    }

    private static final int R = 26;

    private TrieNode root;

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

    public boolean hasPattern(String pattern) {
        return hasPattern(pattern, root, 0);
    }

    private boolean hasPattern(String pattern, TrieNode node, int i) {
        if (node == null)
            return false;
        if (i == pattern.length()) {
            return node.value != null;
        }
        if (pattern.charAt(i) == '.') {
            for (int k = 0; k < R; k++) {
                if (hasPattern(pattern, node.children[k], i + 1))
                    return true;
            }
        } else {
            char c = pattern.charAt(i);
            int index = c - 'a';
            return hasPattern(pattern, node.children[index], i + 1);
        }
        return false;
    }
}

class WordDictionary {
    TrieSet trieSet;

    public WordDictionary() {
        this.trieSet = new TrieSet();
    }

    public void addWord(String word) {
        trieSet.insert(word);
    }

    public boolean search(String word) {
        return trieSet.hasPattern(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end
