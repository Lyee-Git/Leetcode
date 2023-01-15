/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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

    private TreeNode construct(int[] nums, int lo, int hi) {
        if (lo > hi)
            return null;
        int maxVal = Integer.MIN_VALUE, maxIdx = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = construct(nums, lo, maxIdx - 1);
        root.right = construct(nums, maxIdx + 1, hi);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
}
// @lc code=end
