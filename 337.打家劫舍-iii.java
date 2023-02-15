/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start

class Solution {
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

    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    int[] dp(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        int notrob = Math.max(left[1], left[0]) +
                Math.max(right[1], right[0]);
        int rob = root.val + left[0] + right[0];
        return new int[] { notrob, rob };
    }
}
// @lc code=end
