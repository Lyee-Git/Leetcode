
/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */
import java.util.*;

// @lc code=start
class TrieSet {
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

    public String shortestPrefix(String word) {
        TrieNode p = root;
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < word.length(); i++) {
            if (p == null)
                break;
            if (p.value != null) {
                return res.toString();
            }
            char c = word.charAt(i);
            int index = c - 'a';
            p = p.children[index];
            res.append(c);
        }
        // left one at word.length() in which case (word) is a key itself
        if (p != null && p.value != null)
            return word;
        return "";
    }

    public String longestPrefix(String word) {
        TrieNode p = root;
        StringBuilder res = new StringBuilder();
        int maxLen = 0;
        for (int i = 0; i < word.length(); i++) {
            if (p == null)
                break;
            if (p.value != null) {
                maxLen = Math.max(maxLen, res.length());
            }
            char c = word.charAt(i);
            int index = c - 'a';
            p = p.children[index];
            res.append(c);
        }
        // left one at word.length() in which case word is a key itself
        if (p != null && p.value != null) {
            maxLen = Math.max(maxLen, res.length());
        }
        if (maxLen != 0)
            return res.substring(0, maxLen);
        return "";
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        int n = words.length;
        TrieSet trieSet = new TrieSet();
        for (String word : dictionary)
            trieSet.insert(word);
        for (int i = 0; i < n; i++) {
            String word = words[i];
            String prefix = trieSet.shortestPrefix(word);
            if (!prefix.isEmpty()) {
                sb.append(prefix);
            } else {
                sb.append(word);
            }
            if (i != n - 1)
                sb.append(' ');
        }
        return sb.toString();
    }
}
// @lc code=end
