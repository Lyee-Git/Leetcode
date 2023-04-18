/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start
class TrieNode {
    TrieNode[] children = new TrieNode[26];
}

class Solution {
    int res = 0;

    public void insert(TrieNode root, String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            c -= 'a';
            if (p.children[c] == null) {
                p.children[c] = new TrieNode();
            }
            p = p.children[c];
        }
    }

    public void dfs(TrieNode node, int len) {
        boolean isLeafNode = true;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                isLeafNode = false;
                dfs(node.children[i], len + 1);
            }
        }
        if (isLeafNode) {
            res += len + 1;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            String newWord = sb.reverse().toString();
            insert(root, newWord);
        }
        dfs(root, 0);
        return res;
    }

}
// @lc code=end
