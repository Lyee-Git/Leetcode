/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
 */

// @lc code=start
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

    // info[0]: isBST or not
    // [1] & [2]: minVal in subTree
    // [3]: Sum of SubTree
    int Maxsum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root);
        return Maxsum;
    }

    private int[] traverse(TreeNode node) {
        if (node == null)
            return new int[] { 1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        int[] info = new int[4];
        int[] leftInfo = traverse(node.left);
        int[] rightInfo = traverse(node.right);
        if (leftInfo[0] == 1 && rightInfo[0] == 1 &&
                leftInfo[2] < node.val && rightInfo[1] > node.val) {
            info[0] = 1;
            info[1] = Math.min(leftInfo[1], node.val);
            info[2] = Math.max(rightInfo[2], node.val);
            info[3] = leftInfo[3] + rightInfo[3] + node.val;
            if (info[3] > Maxsum)
                Maxsum = info[3];
        } else
            info[0] = 0;
        return info;
    }
}
// @lc code=end
