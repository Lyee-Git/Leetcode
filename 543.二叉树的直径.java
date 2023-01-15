/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start
/**
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

    int ans = 1;

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans - 1;
    }
}
// @lc code=end
