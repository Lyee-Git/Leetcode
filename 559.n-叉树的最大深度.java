/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.

*/
import java.util.*;
import java.lang.*;

class Solution {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    int depth = 0;
    int res = 0;

    public int maxDepth(Node root) {
        traverse(root);
        return res;
    }

    private void traverse(Node root) {
        if (root == null)
            return;
        // 前序位置先处理完本节点，看能不能更新res，再看子节点
        depth++;
        res = Math.max(res, depth);
        for (Node node : root.children) {
            traverse(node);
        }
        depth--;

    }

    // public int maxDepth(Node root) {
    // if (root == null)
    // return 0;
    // int subTreeMaxDepth = 0;
    // for (Node node : root.children)
    // subTreeMaxDepth = Math.max(maxDepth(node), subTreeMaxDepth);
    // return subTreeMaxDepth + 1;
    // }
}
// @lc code=end
