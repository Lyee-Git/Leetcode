
/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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

    public void flatten(TreeNode root) {
        // 迭代版本 O(1) 空间复杂度
        if (root == null)
            return;
        TreeNode cur = root;
        while (cur != null) {
            // 只有左子树不为空时需要展开
            if (cur.left != null) {
                TreeNode left = cur.left;
                TreeNode predecessor = left;
                while (predecessor.right != null)
                    predecessor = predecessor.right;
                predecessor.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }

        // 递归版本
        // if (root == null)
        // return;
        // flatten(root.left);
        // flatten(root.right);
        // if (root.left != null) {
        // TreeNode leftBottom = root.left;
        // while (leftBottom.right != null)
        // leftBottom = leftBottom.right;
        // leftBottom.right = root.right;
        // root.right = root.left;
        // root.left = null;
        // }
    }
}
// @lc code=end
