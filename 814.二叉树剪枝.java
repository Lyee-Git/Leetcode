/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 */

// @lc code=start
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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = pruneTree(root.left);
        root.left = left;
        TreeNode right = pruneTree(root.right);
        root.right = right;
        if (left == null && right == null && root.val == 0) {
            return null;
        } else
            return root;
    }
}
// @lc code=end
