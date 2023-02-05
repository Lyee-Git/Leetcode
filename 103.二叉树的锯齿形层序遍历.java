/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 */
import java.util.*;
import java.util.PrimitiveIterator.OfDouble;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flagOrder = true;
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int s = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < s; i++) {
                TreeNode top = q.poll();
                if (flagOrder)
                    level.addLast(top.val);
                else
                    level.addFirst(top.val);
                if (top.left != null)
                    q.offer(top.left);
                if (top.right != null)
                    q.offer(top.right);
            }
            res.add(level);
            flagOrder = !flagOrder;
        }
        return res;
    }
}
// @lc code=end
