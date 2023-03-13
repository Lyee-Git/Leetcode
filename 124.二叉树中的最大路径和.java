/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            res = Math.max(res, root.val);
            return root.val;
        }
        int leftGain = dfs(root.left);
        int rightGain = dfs(root.right);
        int maxGain = root.val;
        if (leftGain > 0 || rightGain > 0) {
            maxGain += Math.max(leftGain, rightGain);
        }
        int pathSum = root.val;
        pathSum = leftGain > 0 ? pathSum + leftGain : pathSum;
        pathSum = rightGain > 0 ? pathSum + rightGain : pathSum;
        res = Math.max(res, pathSum);
        return maxGain;
    }
}
// @lc code=end
