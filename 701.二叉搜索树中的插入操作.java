/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public class TreeNode {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        if (node == null)
            return new TreeNode(val);
        while (node != null) {
            if (node.val < val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else
                    node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else
                    node = node.left;
            }
        }
        return root;
    }
}
// @lc code=end
